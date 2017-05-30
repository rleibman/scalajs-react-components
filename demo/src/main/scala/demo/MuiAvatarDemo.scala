package demo

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiAvatarDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  import Mui.SvgIcons

  val component = ReactComponentB[Unit]("MuiAvatarDemo")
    .render(P => {
      <.div(
          MuiAvatar(key = "1", backgroundColor = "grey700", color = "deepPurple200", icon = SvgIcons.ActionAccessible()())(),
          MuiAvatar(key = "2", size = 120, backgroundColor = "lime600")(js.defined("Ø")),
          MuiAvatar(key = "3")(js.defined("one")),
          MuiAvatar(key = "4")(js.defined("two")),
          MuiAvatar(key = "5", backgroundColor = "red400")(SvgIcons.ActionAccountBalanceWallet()())
      )
    }).build

  // EXAMPLE:END

  def apply() = component()
}
