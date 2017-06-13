package demo.routes

import demo.pages.SuiPage
import demo.components.semanticui._
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object SuiRouteModule {
  case object Info extends LeftRoute("Info", "info", () => SuiInfo().vdomElement)

  case object Button extends LeftRoute("Button", "button", () => SuiButtonDemo().vdomElement)

  case object Container extends LeftRoute("Container", "container", () => SuiContainerDemo().vdomElement)

  case object Divider extends LeftRoute("Divider", "divider", () => SuiDividerDemo().vdomElement)

  case object Flag extends LeftRoute("Flag", "flag", () => SuiFlagDemo().vdomElement)

  case object Header extends LeftRoute("Header", "header", () => SuiHeaderDemo().vdomElement)

  case object Icon extends LeftRoute("Icon", "icon", () => SuiIconDemo().vdomElement)

  case object Input extends LeftRoute("Input", "input", () => SuiInputDemo().vdomElement)

  case object SuiList extends LeftRoute("List", "list", () => SuiListDemo().vdomElement)

  case object Grid extends LeftRoute("Grid", "grid", () => SuiGridDemo().vdomElement)

  val menu: List[LeftRoute] = List(
    Info,
    Button,
    Container,
    Divider,
    Flag,
    Header,
    Icon,
    Input,
    SuiList,
    Grid
  )

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu
      .map(i => staticRoute(i.route, i) ~> renderR(r => SuiPage(i, r)))
      .reduce(_ | _)
  }
}