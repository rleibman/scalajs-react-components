package demo

import chandu0101.scalajs.react.components.ReactTapEventPlugin
import demo.routes.AppRouter
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp


object ReactApp extends JSApp {

  override def main(): Unit = {
    // remove waiting page stuff
    if (!js.isUndefined(g.loadingElement)) {
      g.document.body.removeChild(g.loadingElement)
      g.loadingElement = js.undefined
      dom.document.body.className.replace("pg-loading", "")
      dom.document.body.className += " pg-loaded"
    }

    //todo: dev-server complains that we load several times?
//    ReactTapEventPlugin(js.undefined)
    ReactTapEventPlugin

    AppCSS.load()
    val router = AppRouter.router()
    router.renderIntoDOM(dom.document.getElementById("container"))
    ()
  }
}