package demo
package routes

import demo.components.reacttable._
import demo.pages.ReactTablePage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object ReactTableRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactTableInfo().vdomElement)

  case object Basic extends LeftRoute("Search ,Pagination", "basic", () => ReactTableBasic().vdomElement)

  case object Sorting extends LeftRoute("Sorting", "sort", () => ReactTableSorting().vdomElement)

  case object CustomCell extends LeftRoute("Custom Cell", "customcell", () => ReactTableCustomCell().vdomElement)

  case object CustomColumn extends LeftRoute("Custom Colum Size", "customcolumsize", () => ReactTableCustomColumnSize().vdomElement)

  val menu: List[LeftRoute] = List(Info, Basic, Sorting, CustomCell, CustomColumn)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactTablePage(i, r))).reduce(_ | _)

  }
}
