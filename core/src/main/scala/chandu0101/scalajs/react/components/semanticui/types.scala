package chandu0101.scalajs.react.components.semanticui

import scala.scalajs.js

class ButtonAnimatedType(val value: String) extends js.Any
object ButtonAnimatedType {
  val fade = ButtonAnimatedType("fade")
  val vertical = ButtonAnimatedType("vertical")
  val values = List(fade, vertical)

  def apply(value: String) = new ButtonAnimatedType(value)
}

class SuiIconType(val value: String) extends js.Any
object SuiIconType {
  //Add all icons here
  def apply(value: String) = new SuiIconType(value)
}

class SuiCountry(val value: String) extends js.Any
object SuiCountry {
  //Add all countries here
  def apply(value: String) = new SuiCountry(value)
}
