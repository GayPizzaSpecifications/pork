package gay.pizza.pork.minimal

import gay.pizza.pork.ast.CompilationUnit
import gay.pizza.pork.ast.NodeVisitor
import gay.pizza.pork.ast.visit
import gay.pizza.pork.evaluator.*
import gay.pizza.pork.ffi.JavaAutogenContentSource
import gay.pizza.pork.ffi.JavaNativeProvider
import gay.pizza.pork.ffi.JnaNativeProvider
import gay.pizza.pork.frontend.ContentSource
import gay.pizza.pork.frontend.ImportLocator
import gay.pizza.pork.frontend.DynamicImportSource
import gay.pizza.pork.frontend.World
import gay.pizza.pork.parser.*
import gay.pizza.pork.stdlib.PorkStdlib

abstract class Tool {
  abstract fun createCharSource(): CharSource
  abstract fun createContentSource(): ContentSource
  abstract fun rootFilePath(): String

  val rootImportLocator: ImportLocator
    get() = ImportLocator("local", rootFilePath())

  fun tokenize(): TokenStream =
    Tokenizer(createCharSource()).tokenize()

  fun parse(attribution: NodeAttribution = DiscardNodeAttribution): CompilationUnit =
    Parser(TokenStreamSource(tokenize()), attribution).parseCompilationUnit()

  fun highlight(scheme: HighlightScheme): List<Highlight> =
    Highlighter(scheme).highlight(tokenize())

  fun reprint(): String = buildString { visit(Printer(this)) }

  fun <T> visit(visitor: NodeVisitor<T>): T = visitor.visit(parse())

  fun loadMainFunction(scope: Scope, setupEvaluator: Evaluator.() -> Unit = {}): CallableFunction {
    val world = buildWorld()
    val evaluator = Evaluator(world, scope)
    setupEvaluator(evaluator)
    val resultingScope = evaluator.evaluate(rootImportLocator)
    return resultingScope.value("main") as CallableFunction
  }

  fun buildWorld(): World {
    val fileContentSource = createContentSource()
    val dynamicImportSource = DynamicImportSource()
    dynamicImportSource.addContentSource("std", PorkStdlib)
    dynamicImportSource.addContentSource("local", fileContentSource)
    dynamicImportSource.addContentSource("java", JavaAutogenContentSource)
    return World(dynamicImportSource)
  }

  fun run(scope: Scope, quiet: Boolean = false) {
    val main = loadMainFunction(scope, setupEvaluator = {
      addNativeProvider("internal", InternalNativeProvider(quiet = quiet))
      addNativeProvider("ffi", JnaNativeProvider())
      addNativeProvider("java", JavaNativeProvider())
    })
    main.call(emptyList(), CallStack())
  }
}
