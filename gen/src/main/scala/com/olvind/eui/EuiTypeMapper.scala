package com.olvind
package eui

object EuiTypeMapper extends TypeMapper {
  val typeT = Normal("T").generic("T")
  val typeTJs = Normal("T").genericJs("T")

  def apply(compName: CompName, fieldName: PropName, typeString: String): Type = {
    def is(s: String) =
      fieldName.value.toLowerCase contains s.toLowerCase
    def split(drop: Int, s: String) =
      s.split("[\'\"\\(\\)\\[\\],\\s]").map(_.trim).filterNot(_.isEmpty).drop(drop)

    (compName.value, fieldName.value, typeString) match {
      //      /* Double => Int */
      //      case (_, "autoHideDuration", "number") => Normal("Int")
      //
      //      /* specific */
      //      case ("AutoComplete", "dataSource", "Mui.array") => Normal("js.Array[String]")
      //
      //      /* general */
      case (_, _, "bool") => Normal("Boolean")
      case (_, _, "React.bool") => Normal("Boolean")
      case (_, _, "string") => Normal("String")
      case (_, _, "React.string") => Normal("String")
      case (_, _, "React.object") => Normal("js.Object")
      case (_, "children", "React.node") => Normal("VdomNode")
      case (_, _, "React.node") => Normal("ReactNode")
      case (_, "children", "React.element") => Normal("VdomElement")
      case (_, _, "React.element") => Normal("ReactElement")
      case (_, _, "number") => Normal("Double")
      case (_, _, "React.number") => Normal("Double")
      case (_, _, enum) if enum.contains("React.oneOf") => Enum(compName, split(1, enum))
      case (_, _, enum) if enum.contains("oneOfType") => Normal(split(1, enum) map (t => apply(compName, fieldName, t)) map (_.name) mkString " | ")
      case (_, "children", "React.arrayOf(React.element)") => Normal("js.Array[VdomElement]")
      case (_, _, "React.func") => Normal(EuiTypeMapperFunction(compName, fieldName))
      //        Normal("js.Function")

    }
  }
}
