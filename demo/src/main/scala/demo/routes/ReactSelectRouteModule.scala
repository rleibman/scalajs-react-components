package demo
package routes

import demo.components.reactselect.{ ReactSelectAsyncDemo, ReactSelectDemo, ReactSelectInfo }
import demo.pages.ReactSelectPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactSelectRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactSelectInfo().vdomElement)

  case object Demo extends LeftRoute("Demo", "demo", () => ReactSelectDemo().vdomElement)

  case object AsyncDemo extends LeftRoute("Async demo", "async", () => ReactSelectAsyncDemo().vdomElement)

  val menu: List[LeftRoute] = List(Info, Demo, AsyncDemo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactSelectPage(i, r))).reduce(_ | _)

  }
}
