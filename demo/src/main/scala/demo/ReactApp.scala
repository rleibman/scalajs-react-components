package demo

import demo.routes.AppRouter
import org.scalajs.dom
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{ global => g }
import scala.scalajs.js.JSApp

object ReactApp extends JSApp {
  def require(): Unit = {
    WebpackRequire.React
    WebpackRequire.ReactDOM
    ()
  }
  require()

  override def main(): Unit = {
    // remove waiting page stuff
    if (!js.isUndefined(g.loadingElement)) {
      g.document.body.removeChild(g.loadingElement)
      g.loadingElement = js.undefined
      dom.document.body.className.replace("pg-loading", "")
      dom.document.body.className += " pg-loaded"
    }
    AppCSS.load()

    val router = AppRouter.router()
    router.renderIntoDOM(dom.document.getElementById("container"))
    ()
  }
}