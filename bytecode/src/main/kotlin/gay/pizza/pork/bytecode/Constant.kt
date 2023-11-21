package gay.pizza.pork.bytecode

import kotlinx.serialization.Serializable

@Serializable
data class Constant(val id: UInt, val tag: ConstantTag, val value: ByteArray) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    other as Constant

    if (id != other.id) return false
    if (!value.contentEquals(other.value)) return false
    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + value.contentHashCode()
    return result
  }
}
