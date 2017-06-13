package demo
package routes

import demo.components.{ ReactInfiniteInfo, ReactInfiniteDemo }
import demo.pages.ReactInfinitePage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object ReactInfiniteRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactInfiniteInfo().vdomElement)

  case object Demo extends LeftRoute("Demo", "demo", () => ReactInfiniteDemo().vdomElement)

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactInfinitePage(i, r))).reduce(_ | _)

  }
}
