package gay.pizza.pork.tool

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import gay.pizza.dough.fs.PlatformFsProvider
import gay.pizza.pork.ast.gen.Symbol
import gay.pizza.pork.compiler.Compiler
import gay.pizza.pork.minimal.FileTool
import gay.pizza.pork.vm.VirtualMachine

class CompileCommand : CliktCommand(help = "Compile Pork to Bytecode", name = "compile") {
  val path by argument("file")

  override fun run() {
    val tool = FileTool(PlatformFsProvider.resolve(path))
    val world = tool.buildWorld()
    val compiler = Compiler()
    val slab = world.load(tool.rootImportLocator)
    val compiledSlab = compiler.compilableSlabs.of(slab)
    val compiledMain = compiledSlab.resolve(Symbol("main"))
      ?: throw RuntimeException("'main' function not found.")
    val compiledWorld = compiler.compile(compiledMain)
    for (symbol in compiledWorld.symbolTable.symbols) {
      val code = compiledWorld.code.subList(symbol.offset.toInt(), (symbol.offset + symbol.size).toInt())
      println(symbol.id)
      for ((index, op) in code.withIndex()) {
        var annotation = ""
        val annotations = compiledWorld.annotations.filter { it.inst == (symbol.offset + index.toUInt()) }
        if (annotations.isNotEmpty()) {
          annotation = " ; ${annotations.joinToString(", ") { it.text}}"
        }
        println("  ${symbol.offset + index.toUInt()} ${op.code.name} ${op.args.joinToString(" ")}${annotation}")
      }
    }
    val vm = VirtualMachine(compiledWorld)
    vm.execute()
  }
}
