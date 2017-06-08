package com.olvind
package sui

object SuiTypeMapperFunction {
  val Callback = "Callback"

  def apply(compName: CompName, name: PropName): String =
    (compName.value, name.value) match {
      case (_, _) =>
        println(s"(${compName.value}, ${name.value}) MapperFunction is missing")
        Callback
    }
}
