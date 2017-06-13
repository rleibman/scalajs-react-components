package demo
package routes

import demo.components.{ ReactTagsInputInfo, ReactTagsInputDemo }
import demo.pages.ReactTagsInputPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactTagsInputRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactTagsInputInfo().vdomElement)

  case object Demo extends LeftRoute("Demo", "demo", () => ReactTagsInputDemo().vdomElement)

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactTagsInputPage(i, r))).reduce(_ | _)

  }
}
