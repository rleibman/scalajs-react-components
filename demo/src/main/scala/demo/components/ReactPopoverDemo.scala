package demo.components

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.ReactPopOver
import chandu0101.scalajs.react.components.ReactPopOver.{ Props, State }
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.component.Scala.MutableRef
import japgolly.scalajs.react.CtorType.PropsAndChildren

object ReactPopoverDemo {
  //
  //  object Style {
  //    val popoverExample = TagMod(^.display := "flex", ^.flexDirection := "column", ^.alignItems := "center")
  //  }
  //  val code = GhPagesMacros.exampleSource
  //
  //  // EXAMPLE:START
  //
  //  class Backend(t: BackendScope[_, _]) {
  //    val topRef = ScalaComponent.mutableRefTo(ReactPopOver.component) //(ref = "top")
  //    val rightRef = ScalaComponent.mutableRefTo(ReactPopOver.component) //(ref = "right")
  //    val leftRef = ScalaComponent.mutableRefTo(ReactPopOver.component) //(ref = "left")
  //    val bottomRef = ScalaComponent.mutableRefTo(ReactPopOver.component) //(ref = "bottom")
  //
  //    //    val topRef = Ref.to(ReactPopOver.component, "top")
  //    //    val rightRef = Ref.to(ReactPopOver.component, "right")
  //    //    val leftRef = Ref.to(ReactPopOver.component, "left")
  //    //    val bottomRef = Ref.to(ReactPopOver.component, "bottom")
  //
  //    def toggleCB(ref: MutableRef[ReactPopOver.Props, ReactPopOver.State, ReactPopOver.Backend, PropsAndChildren]): ReactEventFromHtml => Callback =
  //      e => CallbackOption.liftOptionLike(ref(t)).flatMap(_.backend.toggle(e.target))
  //
  //    def render = {
  //      <.div(
  //        <.h3("Demo"),
  //        CodeExample(code, "ReactPopover")(
  //          <.div(Style.popoverExample)(
  //            <.div(^.padding := "20px")(
  //              topRef.component(ReactPopOver.Props(placement = "top", title = "Top Title"))("I am Top Pop Over"),
  //              LocalDemoButton(name = "Top Button", onButtonClick = toggleCB(topRef))
  //            ),
  //            <.div(^.padding := "20px")(
  //              leftRef.component(ReactPopOver.Props(placement = "left", title = "Left Title"))("I am Left Popover"),
  //              LocalDemoButton(name = "Left Button", onButtonClick = toggleCB(leftRef))
  //            ),
  //            <.div(^.padding := "20px")(
  //              rightRef.component(ReactPopOver.Props(placement = "right", title = "Right Title"))("I am right Popover"),
  //              LocalDemoButton(name = "Right Button", onButtonClick = toggleCB(rightRef))
  //            ),
  //            <.div(^.padding := "20px")(
  //              bottomRef.component(ReactPopOver.Props(placement = "bottom", title = "Bottom Title"))("I am bottom Popover"),
  //              LocalDemoButton(name = "Bottom Button", onButtonClick = toggleCB(bottomRef))
  //            )
  //          )
  //        )
  //      )
  //    }
  //  }
  //
  //  val component = ScalaComponent.builder[Unit]("ReactPopoverDemo")
  //    .renderBackend[Backend]
  //    .build
  //
  //  // EXAMPLE:END
  //
  //  def apply() = component()
}