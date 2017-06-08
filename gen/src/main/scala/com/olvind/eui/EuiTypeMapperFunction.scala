package com.olvind
package eui

object EuiTypeMapperFunction {
  val Callback = "Callback"

  def apply(compName: CompName, name: PropName): String =
    (compName.value, name.value) match {
      case ("Dropzone", "onDrop") => Callback //TODO
      case ("Page", "onSelect") => Callback //TODO
      case _ => throw new Error(s"There was no function type mapping in ${getClass()} for component=${compName} prop=${name}")
    }
}
