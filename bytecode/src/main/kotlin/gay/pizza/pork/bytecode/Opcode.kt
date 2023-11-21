package gay.pizza.pork.bytecode

enum class Opcode(val id: UByte) {
  Constant(1u),
  None(2u),
  False(3u),
  True(4u),
  Pop(5u),
  Jump(6u),
  JumpIf(7u),
  Not(8u),
  UnaryPlus(9u),
  UnaryMinus(10u),
  BinaryNot(11u),
  And(20u),
  Native(24u),
  Return(10u),
  StoreLocal(16u),
  LoadLocal(17u),
  Add(18u),
  Subtract(19u),
  Multiply(20u),
  Divide(21u),
  CompareEqual(22u),
  CompareLesser(23u),
  CompareGreater(24u),
  CompareLesserEqual(25u),
  CompareGreaterEqual(26u),
  Or(27u),
  BinaryAnd(28u),
  BinaryOr(29u),
  BinaryXor(30u),
  ListMake(31u),
  ListSize(32u),
  Integer(33u),
  Double(34u),
  Call(35u),
  EuclideanModulo(36u),
  Remainder(37u),
  Index(38u),
  ScopeIn(39u),
  ScopeOut(40u),
  ReturnAddress(41u),
  End(255u),
}
