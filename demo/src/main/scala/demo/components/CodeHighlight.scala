package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.component.Generic.toComponentCtor

import org.scalajs.dom
import org.scalajs.dom.ext.PimpedNodeList

object CodeHighlight {
  val component = ScalaComponent.builder[String]("CodeHighLighter")
    .render_P(str => <.code(^.`class` := "scala", ^.padding := "20px", str))
    .configure(_.componentDidMount(_ => applySyntaxHighlight).componentDidUpdate(_ => applySyntaxHighlight))
    .build

  def applySyntaxHighlight = Callback {
    import scala.scalajs.js.Dynamic.{ global => g }
    val nodeList = dom.document.querySelectorAll("code").toArray
    nodeList.foreach(n => g.hljs.highlightBlock(n))
  }

  def apply(code: String) = component(code)
}