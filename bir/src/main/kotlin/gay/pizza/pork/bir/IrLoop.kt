package gay.pizza.pork.bir

data class IrLoop(
  override val symbol: IrSymbol,
  val condition: IrCodeElement,
  val inner: IrCodeElement
) : IrCodeElement, IrSymbolOwner {
  override fun crawl(block: (IrElement) -> Unit) {
    block(symbol)
    block(condition)
    block(inner)
  }
}
