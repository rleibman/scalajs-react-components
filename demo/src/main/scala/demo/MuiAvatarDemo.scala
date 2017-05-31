package demo

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiAvatarDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  import Mui.SvgIcons

  val component =
    ScalaComponent
    .builder[Unit]("MuiAvatarDemo")
    .render(P => {
      <.div(
          MuiAvatar(
            key = "1",
            backgroundColor = "grey700",
            color = "deepPurple200",
            icon = js.defined(SvgIcons.ActionAccessible()())
          )(),
          MuiAvatar(key = "2", size = 120, backgroundColor = "lime600")("Ø"),
          MuiAvatar(key = "3")("one"),
          MuiAvatar(key = "4")("two"),
          MuiAvatar(key = "5", backgroundColor = "red400")(SvgIcons.ActionAccountBalanceWallet()())
      )
    }).build

  // EXAMPLE:END

  def apply(): Unmounted[Unit, Unit, Unit] =
    component()
}
