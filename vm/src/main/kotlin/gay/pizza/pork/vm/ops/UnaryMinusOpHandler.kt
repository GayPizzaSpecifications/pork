package gay.pizza.pork.vm.ops

import gay.pizza.pork.bytecode.Op
import gay.pizza.pork.bytecode.Opcode
import gay.pizza.pork.vm.InternalMachine
import gay.pizza.pork.vm.OpHandler

object UnaryMinusOpHandler : OpHandler(Opcode.UnaryMinus) {
  override fun handle(machine: InternalMachine, op: Op) {
    val value = machine.pop<Int>()
    machine.push(-value)
  }
}
