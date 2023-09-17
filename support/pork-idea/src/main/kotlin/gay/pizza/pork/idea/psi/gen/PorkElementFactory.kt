// GENERATED CODE FROM PORK AST CODEGEN
package gay.pizza.pork.idea.psi.gen

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import gay.pizza.pork.ast.NodeType
import gay.pizza.pork.idea.PorkElementTypes

object PorkElementFactory {
  fun create(node: ASTNode): PsiElement =
    when (PorkElementTypes.nodeTypeFor(node.elementType)) {
      NodeType.Symbol -> SymbolElement(node)
      NodeType.Block -> BlockElement(node)
      NodeType.CompilationUnit -> CompilationUnitElement(node)
      NodeType.LetAssignment -> LetAssignmentElement(node)
      NodeType.VarAssignment -> VarAssignmentElement(node)
      NodeType.SetAssignment -> SetAssignmentElement(node)
      NodeType.InfixOperation -> InfixOperationElement(node)
      NodeType.BooleanLiteral -> BooleanLiteralElement(node)
      NodeType.FunctionCall -> FunctionCallElement(node)
      NodeType.FunctionDefinition -> FunctionDefinitionElement(node)
      NodeType.LetDefinition -> LetDefinitionElement(node)
      NodeType.If -> IfElement(node)
      NodeType.ImportDeclaration -> ImportDeclarationElement(node)
      NodeType.IntegerLiteral -> IntegerLiteralElement(node)
      NodeType.LongLiteral -> LongLiteralElement(node)
      NodeType.DoubleLiteral -> DoubleLiteralElement(node)
      NodeType.ListLiteral -> ListLiteralElement(node)
      NodeType.Parentheses -> ParenthesesElement(node)
      NodeType.PrefixOperation -> PrefixOperationElement(node)
      NodeType.SuffixOperation -> SuffixOperationElement(node)
      NodeType.StringLiteral -> StringLiteralElement(node)
      NodeType.SymbolReference -> SymbolReferenceElement(node)
      NodeType.While -> WhileElement(node)
      NodeType.ForIn -> ForInElement(node)
      NodeType.Break -> BreakElement(node)
      NodeType.Continue -> ContinueElement(node)
      NodeType.NoneLiteral -> NoneLiteralElement(node)
      NodeType.Native -> NativeElement(node)
      NodeType.IndexedBy -> IndexedByElement(node)
      else -> ASTWrapperPsiElement(node)
    }
}
