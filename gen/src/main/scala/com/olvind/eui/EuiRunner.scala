package com.olvind
package eui

import ammonite.ops.FileType.Dir
import ammonite.ops.{ Path, pwd }

import scala.util.{ Failure, Success, Try }

object EuiRunner extends App {
  object ExistingFolder {
    def unapply(s: String): Option[Path] =
      Try {
        val p = Path(s, pwd)
        (p, p.fileType)
      } match {
        case Success((p, Dir)) =>
          Some(p)
        case Success((p, _)) =>
          System.err.println(s"Illegal argument: s. must be folder")
          None
        case Failure(th) =>
          System.err.println(s"Illegal argument $s: ${th.getMessage}")
          None
      }
  }

  args.toList match {
    case ExistingFolder(buildFolder) :: ExistingFolder(outputFolder) :: Nil =>
      Runner(EuiLibrary(buildFolder), outputFolder)
    case _ =>
      System.err.println("Syntax: EuiRunner <directory with transpiled javascript", "output folder")
  }
}