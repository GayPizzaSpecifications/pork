package gay.pizza.pork.cli

import gay.pizza.pork.parse.CharSource
import gay.pizza.pork.parse.StringCharSource
import java.nio.file.Path
import kotlin.io.path.readText

class FileTool(val path: Path) : Tool() {
  override fun createCharSource(): CharSource = StringCharSource(path.readText())
  override fun resolveImportSource(path: String): CharSource =
    StringCharSource(this.path.parent.resolve(path).readText())
}