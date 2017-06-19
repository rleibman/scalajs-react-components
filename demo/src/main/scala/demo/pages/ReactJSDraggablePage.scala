package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{ LeftRoute, ReactJSDraggableRouteModule }
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactJSDraggablePage {
  case class Backend($: BackendScope[Props, Unit]) {
    def render(P: Props) =
      LeftNavPage(ReactJSDraggableRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ScalaComponent.builder[Props]("ReactJSDraggablePage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}