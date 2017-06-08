package com.olvind
package sui

object SuiTypeMapper extends TypeMapper {
  val typeT = Normal("T").generic("T")
  val typeTJs = Normal("T").genericJs("T")

  def apply(compName: CompName, fieldName: PropName, typeString: String): Type = {
    def is(s: String) =
      fieldName.value.toLowerCase contains s.toLowerCase
    def split(drop: Int, s: String) =
      s.split("[\'\"\\(\\)\\[\\],\\s]").map(_.trim).filterNot(_.isEmpty).drop(drop)

    (compName.value, fieldName.value, typeString) match {
      case (_, _, e) if e.contains("oneOfType") =>
        Normal(split(1, e) map (t => apply(compName, fieldName, t)) map (_.name) mkString " | ")
      case (a, b, enum) if enum.contains("oneOf(") && enum.contains(']') =>
        val found = "(\\[.*?\\])".r.findAllIn(enum).toList
        val array = found.last.replaceAll("\\[|\\]", "").split(", ").map(_.replace("'", "").replace(" ", ""))
        println("-----------------------------------------")
        println(array.mkString(","))
        Enum(compName, array)
      case (a, b, enum) if enum.contains("oneOf(") && !enum.contains(']') =>
        Enum(compName, split(1, enum))

      case (_, _, "_lib.customas") => Normal("js.Any") //TODO: what to do with this?

      /* general */
      case (_, "valueLink", "object") => Normal("js.Any")
      case (_, _, "string") => Normal("String")
      case (_, _, "bool") => Normal("Boolean")
      case (_, "children", "element") => Normal("VdomElement")
      case (_, _, "element") => Normal("ReactElement")
      case (_, "children", "node") => Normal("VdomNode")
      case (_, _, "node") => Normal("ReactNode")
      case (_, _, "number") => Normal("Double")
      case (_, "children", "arrayOf(element)") => Normal("js.Array[ReactElement]")

      case (_, _, "Mui.arrayOf") => Normal("js.Array[js.Any]")
      case (_, "valueLink", "Mui.object") => Normal("js.Any")
      case (_, _, "Mui.string") => Normal("String")
      case (_, _, "Mui.bool") => Normal("Boolean")
      case (_, "children", "Mui.element") => Normal("VdomElement")
      case (_, _, "Mui.element") => Normal("ReactElement")
      case (_, "children", "Mui.node") => Normal("VdomNode")
      case (_, _, "Mui.node") => Normal("ReactNode")
      case (_, _, "Mui.number") => Normal("Double")
      case (_, "children", "Mui.arrayOf(Mui.element)") => Normal("js.Array[ReactElement]")

      case ("AutoComplete", "popoverProps", "object") => Normal("js.Any")
      case ("RadioButtonGroup", "defaultSelected", "any") => Normal("js.Any")
      case ("RadioButtonGroup", "valueSelected", "any") => Normal("js.Any")
      case ("Stepper", "children", "arrayOf(node)") => Normal("js.Any")
      /*Added by roberto@leibman.net*/
      case ("DatePicker", "utils", "object") => Normal("DatePickerUtils") //TODO ???
      case ("SelectField", "dropDownMenuProps", "object") => Normal("DropDownMenuProps") //TODO ???

      case (_, _, "Mui.func") =>
        Normal(SuiTypeMapperFunction(compName, fieldName))
      case (_, _, "func") =>
        Normal(SuiTypeMapperFunction(compName, fieldName))
      case (a, b, c) =>
        println(s"($a,$b,$c) Missing in TypeMapper")
        Normal("js.Any /*//TODO: fix this in the TypeMapper*/")

    }
  }
}
