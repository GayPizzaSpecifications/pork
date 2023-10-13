// GENERATED CODE FROM PORK AST CODEGEN
package gay.pizza.pork.ast.gen

fun NodeParser.parse(type: NodeType): Node =
  when (type) {
    NodeType.Expression -> parseExpression()
    NodeType.Symbol -> parseSymbol()
    NodeType.Declaration -> parseDeclaration()
    NodeType.Definition -> parseDefinition()
    NodeType.Block -> parseBlock()
    NodeType.CompilationUnit -> parseCompilationUnit()
    NodeType.LetAssignment -> parseLetAssignment()
    NodeType.VarAssignment -> parseVarAssignment()
    NodeType.SetAssignment -> parseSetAssignment()
    NodeType.InfixOperation -> parseInfixOperation()
    NodeType.BooleanLiteral -> parseBooleanLiteral()
    NodeType.FunctionCall -> parseFunctionCall()
    NodeType.ArgumentSpec -> parseArgumentSpec()
    NodeType.FunctionDefinition -> parseFunctionDefinition()
    NodeType.LetDefinition -> parseLetDefinition()
    NodeType.If -> parseIf()
    NodeType.ImportPath -> parseImportPath()
    NodeType.ImportDeclaration -> parseImportDeclaration()
    NodeType.IntegerLiteral -> parseIntegerLiteral()
    NodeType.LongLiteral -> parseLongLiteral()
    NodeType.DoubleLiteral -> parseDoubleLiteral()
    NodeType.ListLiteral -> parseListLiteral()
    NodeType.Parentheses -> parseParentheses()
    NodeType.PrefixOperation -> parsePrefixOperation()
    NodeType.SuffixOperation -> parseSuffixOperation()
    NodeType.StringLiteral -> parseStringLiteral()
    NodeType.SymbolReference -> parseSymbolReference()
    NodeType.While -> parseWhile()
    NodeType.ForInItem -> parseForInItem()
    NodeType.ForIn -> parseForIn()
    NodeType.Break -> parseBreak()
    NodeType.Continue -> parseContinue()
    NodeType.NoneLiteral -> parseNoneLiteral()
    NodeType.Native -> parseNative()
    NodeType.IndexedBy -> parseIndexedBy()
    else -> throw RuntimeException("Unable to automatically parse type: ${type.name}")
  }
