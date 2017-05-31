package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.vdom.VdomNode
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiMuiThemeProvider(
  key:      js.UndefOr[String]                       = js.undefined,
  ref:      js.UndefOr[MuiMuiThemeProviderM => Unit] = js.undefined,
  muiTheme: js.UndefOr[js.Object]                     = js.undefined){

  def apply(children: VdomNode*): UnmountedWithRawType[js.Object, Null, RawMounted] = {
    val props = JSMacro[MuiMuiThemeProvider](this)
    val Component = JsComponent[js.Object, Children.Varargs, Null](Mui.MuiThemeProvider)
    Component(props)(children :_*)
  }
}

@js.native
trait MuiMuiThemeProviderM extends js.Object {
  def getChildContext(): js.Dynamic = js.native
}
