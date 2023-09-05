package gay.pizza.pork.ast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("if")
class If(val condition: Expression, val thenExpression: Expression, val elseExpression: Expression?) : Expression() {
  override val type: NodeType = NodeType.If

  override fun <T> visitChildren(visitor: NodeVisitor<T>): List<T> =
    visitor.visitNodes(condition, thenExpression, elseExpression)

  override fun equals(other: Any?): Boolean {
    if (other !is If) return false
    return other.condition == condition && other.thenExpression == thenExpression && other.elseExpression == elseExpression
  }

  override fun hashCode(): Int {
    var result = condition.hashCode()
    result = 31 * result + thenExpression.hashCode()
    result = 31 * result + elseExpression.hashCode()
    result = 31 * result + type.hashCode()
    return result
  }
}