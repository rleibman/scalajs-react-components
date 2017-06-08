package chandu0101

import japgolly.scalajs.react.WebpackRequire
import scala.scalajs.js.JSApp
import org.scalajs.dom
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import chandu0101.scalajs.react.components.materialui._

object HelloWorld { //extends JSApp {
  def require(): Unit = {
    WebpackRequire.React
    WebpackRequire.ReactDOM
    ()
  }
  require()
  case class State()
  case class Backend($: BackendScope[_, _]) {
    def render() = {
      val textField = MuiTextField(id = "yo", defaultValue = "mytext")()
      val all = MuiMuiThemeProvider()(textField)

      <.div("Hello! Please enter your name", all)
    }
  }

  val component = ScalaComponent.builder[Unit]("No args")
    .renderBackend[Backend]
    .build

  def main(): Unit = {
    println("Hello world")
    require()
    val target = dom.document.getElementById("target")
    component().renderIntoDOM(target)
    ()
  }
}