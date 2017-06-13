package com.olvind
package eui

import ammonite.ops._

import scala.language.implicitConversions

case class EuiLibrary(base: Path) extends Library {
  /* todo: make requiresjs clever enough to figure this out by itself */
  override val locations =
    Seq(
      base / 'lib // / 'components
    )

  override val prefixOpt = Some("Eui")
  override val name = "elementalui"
  override val typeMapper = EuiTypeMapper
  override val memberMapper = EuiTypeMemberMethodMapper
  override val indexNames = Set("Elemental.js", "index.js")
  override val packageName = "chandu0101.scalajs.react.components.elementalui"

  val components: Seq[ComponentDef] =
    Seq(
      // ComponentDef(CompName("ElementalAlert")),
      // ComponentDef(CompName("BlankState")),
      // ComponentDef(CompName("BlankStateHeading")),
      // ComponentDef(CompName("ButtonGroup")),
      // ComponentDef(CompName("Button")),
      // ComponentDef(CompName("Card")),
      ComponentDef(CompName("Container")),
      ComponentDef(CompName("Checkbox")),
      // ComponentDef(CompName("Col")),
      // ComponentDef(CompName("Dropdown")),
      // ComponentDef(CompName("EmailInputGroup")),
      ComponentDef(CompName("Dropzone")),
      // ComponentDef(CompName("FileUpload")),
      // ComponentDef(CompName("FormField")),
      // ComponentDef(CompName("FormIconField")),
      // ComponentDef(CompName("FormIcon")),
      // ComponentDef(CompName("FormInput")),
      // ComponentDef(CompName("Form")),
      // ComponentDef(CompName("FormLabel")),
      // ComponentDef(CompName("FormNote")),
      // ComponentDef(CompName("FormRow")),
      // ComponentDef(CompName("FormSelect")),
      ComponentDef(CompName("Glyph")),
      // ComponentDef(CompName("InputGroup")),
      // ComponentDef(CompName("InputGroupSection")),
      // ComponentDef(CompName("ModalBody")),
      // ComponentDef(CompName("ModalFooter")),
      // ComponentDef(CompName("ModalHeader")),
      // ComponentDef(CompName("TransitionPortal")),
      // ComponentDef(CompName("Modal")),
      ComponentDef(CompName("Page")),
      // ComponentDef(CompName("Pagination")),
      // ComponentDef(CompName("PasswordInputGroup")),
      // ComponentDef(CompName("Pill")),
      // ComponentDef(CompName("RadioGroup")),
      // ComponentDef(CompName("ResponsiveText")),
      // ComponentDef(CompName("Row")),
      // ComponentDef(CompName("SegmentedControl")),
      // ComponentDef(CompName("Section")),
      // ComponentDef(CompName("Spinner")),
      // ComponentDef(CompName("Table"))
      // ComponentDef(CompName("Body")),
      // ComponentDef(CompName("Footer")),
      // ComponentDef(CompName("Header")),
      ComponentDef(CompName("Radio"))
    )
}