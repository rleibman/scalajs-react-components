package demo

import chandu0101.scalajs.react.components.WithAsyncScript
import chandu0101.scalajs.react.components.materialui.MuiMuiThemeProvider
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Js
import japgolly.scalajs.react.component.Scala.MountedImpure

object MuiPage {
  private val component =
    ScalaComponent.builder[Unit]("MuiPage")
    .renderStatic {
      WithAsyncScript("assets/material_ui-bundle.js")(
        MuiMuiThemeProvider()(MuiAvatarDemo().vdomElement).vdomElement
      ).vdomElement
    }.build

  def apply(): Js.UnmountedSimple[Unit, MountedImpure[Unit, Unit, Unit]] =
    component()
}
