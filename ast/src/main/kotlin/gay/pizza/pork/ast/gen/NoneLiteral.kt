// GENERATED CODE FROM PORK AST CODEGEN
package gay.pizza.pork.ast.gen

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("noneLiteral")
class NoneLiteral : Expression() {
  override val type: NodeType = NodeType.NoneLiteral

  override fun <T> visit(visitor: NodeVisitor<T>): T =
    visitor.visitNoneLiteral(this)

  override fun equals(other: Any?): Boolean =
    other is NoneLiteral

  override fun hashCode(): Int =
    31 * type.hashCode()
}
