package demo
package routes

import demo.components.{ ReactPopoverInfo, ReactPopoverDemo }
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import demo.pages.ReactPopoverPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object ReactPopoverRouteModule {
  case object Info extends LeftRoute("Info", "info", () => <.div()())

  //  case object Demo extends LeftRoute("Demo", "demo", () => ReactPopoverDemo())

  val menu: List[LeftRoute] = List(Info) //, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => <.div())).reduce(_ | _)

  }
}