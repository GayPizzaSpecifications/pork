package gay.pizza.pork.bir

import kotlinx.serialization.Serializable

@Serializable
data class IrDefinition(
  override val symbol: IrSymbol,
  val type: IrDefinitionType,
  val arguments: List<IrFunctionArgument>,
  val code: IrCodeBlock
) : IrElement, IrSymbolOwner {
  override fun crawl(block: (IrElement) -> Unit) {
    block(symbol)
    arguments.forEach(block)
    block(code)
  }
}
