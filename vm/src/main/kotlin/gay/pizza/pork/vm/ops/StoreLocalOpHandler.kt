package gay.pizza.pork.vm.ops

import gay.pizza.pork.bytecode.Op
import gay.pizza.pork.bytecode.Opcode
import gay.pizza.pork.vm.InternalMachine
import gay.pizza.pork.vm.OpHandler

object StoreLocalOpHandler : OpHandler(Opcode.StoreLocal) {
  override fun handle(machine: InternalMachine, op: Op) {
    machine.storeLocal(op.args[0])
  }
}
