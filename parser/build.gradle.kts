plugins {
  id("gay.pizza.pork.module")
}

dependencies {
  api(project(":ast"))
  api(project(":tokenizer"))

  implementation(project(":common"))
}
