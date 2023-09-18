package gay.pizza.pork.parser

import gay.pizza.pork.ast.Node
import gay.pizza.pork.ast.NodeParser
import gay.pizza.pork.ast.NodeType

abstract class ParserBase(val source: TokenSource, val attribution: NodeAttribution) : NodeParser {
  @Suppress("NOTHING_TO_INLINE")
  protected inline fun <T: Node> guarded(type: NodeType? = null, noinline block: () -> T): T =
    attribution.guarded(type, block)

  protected fun <T> collect(
    peeking: TokenType,
    consuming: TokenType? = null,
    read: () -> T
  ): List<T> {
    val items = mutableListOf<T>()
    while (!peek(peeking)) {
      val item = read()
      if (consuming != null) {
        if (!peek(peeking)) {
          expect(consuming)
        }
      }
      items.add(item)
    }
    return items
  }

  protected fun <T> oneAndContinuedBy(separator: TokenType, read: () -> T): List<T> {
    val items = mutableListOf<T>()
    items.add(read())
    while (peek(separator)) {
      expect(separator)
      items.add(read())
    }
    return items
  }

  protected fun peek(vararg types: TokenType): Boolean {
    val token = peek()
    return types.contains(token.type)
  }

  protected fun next(type: TokenType): Boolean {
    return if (peek(type)) {
      expect(type)
      true
    } else false
  }

  protected fun expect(vararg types: TokenType): Token {
    val token = next()
    if (!types.contains(token.type)) {
      expectedTokenError(token, *types)
    }
    return token
  }

  protected fun <T: Node> expect(vararg types: TokenType, consume: (Token) -> T): T =
    consume(expect(*types))

  protected fun expectedTokenError(token: Token, vararg types: TokenType): Nothing {
    throw ExpectedTokenError(token, token.sourceIndex, *types)
  }

  protected fun next(): Token {
    while (true) {
      val token = source.next()
      if (ignoredByParser(token.type)) {
        continue
      }
      return token
    }
  }

  protected fun peek(): Token {
    while (true) {
      val token = source.peek()
      if (ignoredByParser(token.type)) {
        source.next()
        continue
      }
      return token
    }
  }

  private fun ignoredByParser(type: TokenType): Boolean = when (type) {
    TokenType.BlockComment -> true
    TokenType.LineComment -> true
    TokenType.Whitespace -> true
    else -> false
  }
}
