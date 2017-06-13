package demo
package routes

import demo.components.{ ReactGeomIconInfo, ReactGeomIconDemo }
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import demo.pages.ReactGeomIconPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object ReactGeomIcontRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactGeomIconInfo().vdomElement)

  case object Demo extends LeftRoute("Demo", "demo", () => ReactGeomIconDemo().vdomElement)

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactGeomIconPage(i, r))).reduce(_ | _)

  }
}
