// GENERATED CODE FROM PORK AST CODEGEN
package gay.pizza.pork.idea.psi.gen

import com.intellij.psi.PsiElement
import com.intellij.lang.ASTNode
import gay.pizza.pork.ast.NodeType
import gay.pizza.pork.idea.PorkElementTypes

class FunctionDefinitionElement(node: ASTNode) : PorkNamedElement(node) {
  override fun getName(): String? =
    node.findChildByType(PorkElementTypes.elementTypeFor(NodeType.FunctionDefinition))?.text

  override fun setName(name: String): PsiElement =
    this
}
