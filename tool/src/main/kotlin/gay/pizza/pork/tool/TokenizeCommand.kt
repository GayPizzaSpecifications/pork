package gay.pizza.pork.tool

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import gay.pizza.dough.fs.PlatformFsProvider
import gay.pizza.pork.minimal.FileTool
import gay.pizza.pork.tokenizer.TokenType

class TokenizeCommand : CliktCommand(help = "Tokenize Compilation Unit", name = "tokenize") {
  val path by argument("file")

  override fun run() {
    val tool = FileTool(PlatformFsProvider.resolve(path))
    val tokenSource = tool.tokenize()
    while (true) {
      val token = tokenSource.next()
      println("${token.sourceIndex} ${token.type.name} '${sanitize(token.text)}'")
      if (token.type == TokenType.EndOfFile) {
        break
      }
    }
  }

  private fun sanitize(input: String): String =
    input
      .replace("\n", "\\n")
      .replace("\r", "\\r")
}
