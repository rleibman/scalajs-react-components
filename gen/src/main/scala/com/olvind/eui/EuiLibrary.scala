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
      ComponentDef(CompName("ElementalAlert")),
      //      ComponentDef(CompName("BlankState")),
      //      ComponentDef(CompName("BlankStateHeading")), //Error, two components in one file
      ComponentDef(CompName("ButtonGroup")),
      ComponentDef(CompName("Button"), forceChildren = true, domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Card")),
      ComponentDef(CompName("Container")),
      ComponentDef(CompName("Checkbox"), domeTypeOpt = Some(DomInput)),
      //      ComponentDef(CompName("Col")), // Error, comments
      ComponentDef(CompName("Dropdown")),
      ComponentDef(CompName("EmailInputGroup")),
      ComponentDef(CompName("Dropzone")),
      ComponentDef(CompName("FileUpload")),
      ComponentDef(CompName("FormField"), forceChildren = true),
      ComponentDef(CompName("FormIconField")),
      ComponentDef(CompName("FormIcon")),
      ComponentDef(CompName("FormInput"), forceChildren = true, domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Form")),
      ComponentDef(CompName("FormLabel")),
      ComponentDef(CompName("FormNote")),
      ComponentDef(CompName("FormRow")),
      ComponentDef(CompName("FormSelect")),
      ComponentDef(CompName("Glyph")),
      ComponentDef(CompName("InputGroup"), forceChildren = true),
      ComponentDef(CompName("InputGroupSection")),
      ComponentDef(CompName("ModalBody")),
      ComponentDef(CompName("ModalFooter"), forceChildren = true),
      ComponentDef(CompName("ModalHeader"), forceChildren = true),
      ComponentDef(CompName("Modal")),
      ComponentDef(CompName("Page")),
      ComponentDef(CompName("Pagination")),
      ComponentDef(CompName("PasswordInputGroup")),
      ComponentDef(CompName("Pill")),
      ComponentDef(CompName("RadioGroup")),
      ComponentDef(CompName("ResponsiveText")),
      ComponentDef(CompName("Row")),
      ComponentDef(CompName("SegmentedControl")),
      //      ComponentDef(CompName("Section")),
      ComponentDef(CompName("Spinner")),
      ComponentDef(CompName("Table")),
      //      ComponentDef(CompName("Body")),
      //      ComponentDef(CompName("Footer")),
      //      ComponentDef(CompName("Header")),
      ComponentDef(CompName("Radio"), domeTypeOpt = Some(DomInput))
    )
}