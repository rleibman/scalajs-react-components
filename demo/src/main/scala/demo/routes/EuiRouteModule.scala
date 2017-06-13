package demo.routes

import demo.components.elementalui._
import demo.pages.EuiPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import demo.components.elementalui._

object EuiRouteModule {
  case object Info extends LeftRoute("Info", "info", () => EuiInfo().vdomElement)
  case object Buttons extends LeftRoute("Buttons", "buttons", () => EuiButtonsDemo().vdomElement)
  case object Glyphs extends LeftRoute("Glyphs", "glyphs", () => EuiGlyphsDemo().vdomElement)
  case object Forms extends LeftRoute("Forms", "forms", () => EuiFormsDemo().vdomElement)
  case object Spinner extends LeftRoute("Spinner", "spinner", () => EuiSpinnerDemo().vdomElement)
  case object Modal extends LeftRoute("Modal", "modal", () => EuiModalDemo().vdomElement)
  case object Misc extends LeftRoute("Misc", "misc", () => EuiMiscDemo().vdomElement)
  val menu: List[LeftRoute] = List(
    Info,
    Buttons,
    Glyphs,
    Forms,
    Spinner,
    Modal,
    Misc
  )

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => EuiPage(i, r))).reduce(_ | _)

  }
}
