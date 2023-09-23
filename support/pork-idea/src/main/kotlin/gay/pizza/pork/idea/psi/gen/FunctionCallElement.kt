// GENERATED CODE FROM PORK AST CODEGEN
package gay.pizza.pork.idea.psi.gen

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiReference
import gay.pizza.pork.ast.NodeType
import gay.pizza.pork.idea.psi.PorkElementHelpers
import javax.swing.Icon

class FunctionCallElement(node: ASTNode) : PorkElement(node) {
  override fun getReference(): PsiReference? =
    PorkElementHelpers.referenceOfElement(this, NodeType.FunctionDefinition)

  override fun getIcon(flags: Int): Icon? =
    PorkElementHelpers.iconOf(this)

  override fun getPresentation(): ItemPresentation? =
    PorkElementHelpers.presentationOf(this)
}
