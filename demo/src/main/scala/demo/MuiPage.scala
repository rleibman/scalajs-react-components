package demo

import chandu0101.scalajs.react.components.WithAsyncScript
import chandu0101.scalajs.react.components.materialui.MuiMuiThemeProvider
import japgolly.scalajs.react._

object MuiPage {
  private val component = ScalaComponent.builder[Unit]("MuiPage")
    .render(_ =>
      WithAsyncScript("assets/material_ui-bundle.js")(
        MuiMuiThemeProvider()(MuiAvatarDemo()))
    ).build

  def apply(): ReactComponentU[Unit, Unit, Unit, TopNode] =
    component()
}
