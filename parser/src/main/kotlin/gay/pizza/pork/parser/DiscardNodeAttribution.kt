package gay.pizza.pork.parser

import gay.pizza.pork.ast.Node
import gay.pizza.pork.ast.NodeType

object DiscardNodeAttribution : NodeAttribution {
  override fun push(token: Token) {}
  override fun <T : Node> adopt(node: T) {}
  override fun <T : Node> guarded(type: NodeType?, block: () -> T): T =
    block()
}
