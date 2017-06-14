package com.olvind
package eui

object EuiTypeMapperFunction {
  val Callback = "Callback"

  def apply(compName: CompName, name: PropName): String =
    (compName.value, name.value) match {
      case ("Dropzone", "onDrop") => Callback //TODO
      case ("Page", "onSelect") => Callback //TODO
      case ("Dropdown", "onSelect") => Callback //TODO
      case ("EmailInputGroup", "onChange") => Callback //TODO
      case ("FileUpload", "onChange") => Callback //TODO
      case ("FormInput", "onChange") => Callback //TODO
      case ("FormSelect", "onChange") => Callback //TODO
      case ("ModalHeader", "onClose") => Callback //TODO
      case ("Modal", "onCancel") => Callback //TODO
      case ("Pagination", "onPageSelect") => Callback //TODO
      case ("PasswordInputGroup", "onChange") => Callback //TODO
      case ("PasswordInputGroup", "validatePassword") => Callback //TODO
      case ("Pill", "onClear") => "ReactEvent => Callback"
      case ("Pill", "onClick") => "ReactEventFromHtml => Callback"
      case ("RadioGroup", "onChange") => Callback
      case ("SegmentedControl", "onChange") => Callback
      case _ => throw new Error(s"""case ("${compName.value}", "${name.value}") => Callback  //TODO: Add function type mapping in ${getClass().getName}""")
    }
}
