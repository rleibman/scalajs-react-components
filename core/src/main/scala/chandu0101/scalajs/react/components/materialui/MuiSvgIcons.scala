package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.CssProperties
import japgolly.scalajs.react.{Callback, JsComponentC, JsComponentType, JsComponentU, React, ReactMouseEventFromHtml, VdomNode, TopNode}

import scala.scalajs.js
@js.native
trait MuiSvgIconProps extends js.Any {
  def key:          js.UndefOr[String]
  def ref:          js.UndefOr[String]
  def color:        js.UndefOr[String]
  def hoverColor:   js.UndefOr[String]
  def onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback]
  def onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback]
  def style:        js.UndefOr[CssProperties]
  def viewBox:      js.UndefOr[String]
}

object MuiSvgIcon {
  implicit class SvgIconApply(icon: MuiSvgIcon) {
    def apply(key:          js.UndefOr[String]                       = js.undefined,
              ref:          js.UndefOr[String]                       = js.undefined,
              color:        js.UndefOr[String]                     = js.undefined,
              hoverColor:   js.UndefOr[String]                     = js.undefined,
              onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
              onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
              style:        js.UndefOr[CssProperties]                = js.undefined,
              viewBox:      js.UndefOr[String]                       = js.undefined)
             (childOpt:     js.UndefOr[VdomNode]                    = js.undefined): JsComponentU[MuiSvgIconProps, js.Any, TopNode] = {

      val props = js.Dynamic.literal()
      key.         foreach(v => props.updateDynamic("key")(v))
      ref.         foreach(v => props.updateDynamic("ref")(v))
      color.       foreach(v => props.updateDynamic("color")(v))
      hoverColor.  foreach(v => props.updateDynamic("hoverColor")(v))
      onMouseEnter.foreach(v => props.updateDynamic("onMouseEnter")(v andThen (_.runNow())))
      onMouseLeave.foreach(v => props.updateDynamic("onMouseLeave")(v andThen (_.runNow())))
      style.       foreach(v => props.updateDynamic("style")(v))
      viewBox.     foreach(v => props.updateDynamic("viewBox")(v))

      val f: JsComponentC[MuiSvgIconProps, js.Any, TopNode] =
        React.createFactory(icon)
      val svgProps: MuiSvgIconProps =
        props.asInstanceOf[MuiSvgIconProps]

      childOpt.fold(f(svgProps))(c => f(svgProps, c))
    }
  }
}

@js.native
trait MuiSvgIcon extends JsComponentType[MuiSvgIconProps, js.Any, TopNode]

@js.native
trait MuiSvgIcons extends js.Object {
  def ActionAccessibility: MuiSvgIcon

  def ActionAccessible: MuiSvgIcon

  def ActionAccountBalanceWallet: MuiSvgIcon

  def ActionAccountBalance: MuiSvgIcon

  def ActionAccountBox: MuiSvgIcon

  def ActionAccountCircle: MuiSvgIcon

  def ActionAddShoppingCart: MuiSvgIcon
}