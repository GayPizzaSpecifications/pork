package gay.pizza.pork.bir

import kotlinx.serialization.Serializable

@Serializable
sealed interface IrSymbolOwner {
  var symbol: IrSymbol
}
