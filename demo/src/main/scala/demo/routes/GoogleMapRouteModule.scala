package demo
package routes

import demo.components.googlemap._
import demo.pages.GoogleMapPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object GoogleMapRouteModule {

  case object Info extends LeftRoute("Info", "info", () => GoogleMapInfo().vdomElement)

  case object Basic extends LeftRoute("Basic Map", "basic", () => GoogleMapBasic().vdomElement)

  case object Marker extends LeftRoute("Map With Markers", "markers", () => GoogleMapMarkers().vdomElement)

  case object MutableMarker extends LeftRoute("Mutable Markers", "mutableMarkers", () => MutableGoogleMapMarkers().vdomElement)

  case object MarkerIcon extends LeftRoute("Custom Marker Icon", "markericon", () => GoogleMapCustomMarkerIcon().vdomElement)

  case object MarkerInfoWindow extends LeftRoute("Marker Info Window", "markerinfowindow", () => GoogleMapMarkerInfoWindow().vdomElement)

  val menu: List[LeftRoute] = List(Info, Basic, Marker, MutableMarker, MarkerIcon, MarkerInfoWindow)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => GoogleMapPage(i, r))).reduce(_ | _)

  }
}
