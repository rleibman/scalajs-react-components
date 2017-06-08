package demo
package components
package reactselect

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.reactselect._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import japgolly.scalajs.react.vdom._

object ReactSelectDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(
    value: js.UndefOr[ReactNode] = js.undefined,
    multiValue: js.UndefOr[ReactNode] = js.undefined
  )

  class Backend(t: BackendScope[_, State]) {

    def onChange(value: VdomNode) =
      t.modState(_.copy(value = value)) >>
        Callback.info(s"Chosen $value")

    def onMultiChange(value: VdomNode) =
      t.modState(_.copy(multiValue = value)) >> Callback.info(s"Chosen $value")

    def render(S: State) = {
      val options = js.Array[ValueOption[VdomNode]](
        ValueOption(value = "value1", label = "label1"),
        ValueOption(value = 1, label = "label2"),
        ValueOption(value = "value3", label = "label3"),
        ValueOption(value = "value4", label = "label4"),
        ValueOption(value = "value5", label = "label5")
      )

      <.div(
        CodeExample(code, "Demo")(
          <.div(
            <.h3("Single Select"),
            Select(
              options = options,
              value = S.value,
              onValueClick = (v: ValueOption[VdomNode], e: ReactEvent) => Callback.info(v.toString),
              onChange = onChange _
            )()
          ),
          <.div(
            <.h3("Multi Select"),
            Select(
              options = options,
              value = S.multiValue,
              multi = true,
              onChange = onMultiChange _
            )()
          )
        )
      )
    }
  }

  val component = ScalaComponent.builder[Unit]("ReactSelectDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
