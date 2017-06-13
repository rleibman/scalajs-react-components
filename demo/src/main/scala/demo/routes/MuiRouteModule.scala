package demo
package routes

import demo.components.materialui._
import demo.pages.MuiPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import demo.components._

object MuiRouteModule {

  case object Info extends LeftRoute("Info", "info", () => MuiInfo().vdomElement)

  case object AppBar extends LeftRoute("AppBar", "appbar", () => MuiAppBarDemo().vdomElement)

  case object AutoComplete extends LeftRoute("AutoComplete", "autocomplete", () => MuiAutoCompleteDemo())

  case object Avatar extends LeftRoute("Avatar", "avatar", () => MuiAvatarDemo())

  case object Tabs extends LeftRoute("Tabs", "tabs", () => MuiTabsDemo().vdomElement)

  case object Buttons extends LeftRoute("Buttons", "buttons", () => MuiButtonsDemo().vdomElement)

  case object DatePicker extends LeftRoute("Date Picker", "datepicker", () => MuiDatePickerDemo().vdomElement)

  case object Dialog extends LeftRoute("Dialog", "dialog", () => MuiDialogDemo().vdomElement)

  case object DropDownMenu extends LeftRoute("DropDown Menu", "dropdownmenu", () => MuiDropDownMenuDemo().vdomElement)

  case object Paper extends LeftRoute("Paper", "paper", () => MuiPaperDemo().vdomElement)

  case object Popover extends LeftRoute("Popover", "popover", () => MuiPopoverDemo())

  case object TextField extends LeftRoute("Text Field", "textfield", () => MuiTextFieldDemo().vdomElement)

  case object ThemeProvider extends LeftRoute("Themes", "themes", () => MuiThemeProviderDemo())

  case object Progress extends LeftRoute("Progress Bars", "progress", () => MuiProgressDemo().vdomElement)

  case object SelectField extends LeftRoute("Select Field", "selectfield", () => MuiSelectFieldDemo())

  case object SnackBar extends LeftRoute("SnackBar", "snackbar", () => MuiSnackbarDemo().vdomElement)

  case object Slider extends LeftRoute("Slider", "slider", () => MuiSliderDemo().vdomElement)

  case object SvgIcon extends LeftRoute("Svg icons", "svgicon", () => MuiSvgIconDemo().vdomElement)

  case object TimePicker extends LeftRoute("Time Picker", "timepicker", () => MuiTimePickerDemo().vdomElement)

  case object Switches extends LeftRoute("Switches", "switches", () => MuiSwitchesDemo())

  case object Toolbar extends LeftRoute("Toolbar", "toolbar", () => MuiToolbarDemo().vdomElement)

  case object Drawer extends LeftRoute("Drawer", "drawer", () => MuiDrawerDemo().vdomElement)

  case object Menu extends LeftRoute("Menus", "menus", () => MuiMenuDemo().vdomElement)

  case object MList extends LeftRoute("List", "list", () => MuiListDemo().vdomElement)

  case object Table extends LeftRoute("Table", "table", () => MuiTableDemo().vdomElement)

  val menu: List[LeftRoute] = List(
    Info,
    Updates,
    AppBar,
    AutoComplete,
    Avatar,
    Buttons,
    DatePicker,
    Dialog,
    DropDownMenu,
    Drawer,
    MList,
    Menu,
    Paper,
    Popover,
    Progress,
    SelectField,
    Switches,
    Slider,
    SvgIcon,
    SnackBar,
    TextField,
    ThemeProvider,
    TimePicker,
    Table,
    Tabs,
    Toolbar
  )

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => MuiPage(i, r).vdomElement)).reduce(_ | _)

  }
}