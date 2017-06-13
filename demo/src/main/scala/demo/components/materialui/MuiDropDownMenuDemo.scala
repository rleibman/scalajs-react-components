package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiDropDownMenuDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Item(val id: String, val name: String) extends js.Any

  val items: Seq[Item] =
    Seq(
      new Item("1", "Never"),
      new Item("2", "Every Night"),
      new Item("3", "Weeknights"),
      new Item("4", "Weekends"),
      new Item("5", "Weekly")
    )

  case class Backend($: BackendScope[Unit, Item]) {
    val onChange: (TouchTapEvent, Int, Item) => Callback =
      (e, idx, value) => $.setState(value) >> Callback.info(s"idx: $idx, value: $value")

    def render(chosen: Item) =
      <.div(
        CodeExample(code, "MuiDropDownMenu")(
          MuiDropDownMenu[Item](
            onChange = onChange,
            value = chosen
          )(
            items map {
              case item => MuiMenuItem[Item](key = item.id, value = item, primaryText = item.name)()
            }: _*
          )
        )
      )
  }
  val component = ScalaComponent.builder[Unit]("MuiDropDownMenuDemo")
    .initialState(items.head)
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
