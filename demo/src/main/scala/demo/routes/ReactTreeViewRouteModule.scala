package demo
package routes

import demo.components.{ ReactTreeViewInfo, ReactTreeViewDemo }
import demo.pages.ReactTreeViewPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object ReactTreeViewRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactTreeViewInfo().vdomElement)

  case object Demo extends LeftRoute("Demo", "demo", () => ReactTreeViewDemo().vdomElement)

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactTreeViewPage(i, r))).reduce(_ | _)

  }
}
