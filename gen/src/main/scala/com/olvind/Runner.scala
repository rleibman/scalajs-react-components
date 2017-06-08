package com.olvind

import ammonite.ops.Path
import com.olvind.requiresjs._

import scala.collection.mutable
import java.io.File
import ammonite.ops.RelPath

object Runner {

  def preludeFor(library: Library): String =
    s"""package chandu0101.scalajs.react.components
       |package ${library.name}
       |
       |import chandu0101.macros.tojs.JSMacro
       |import japgolly.scalajs.react._
       |import japgolly.scalajs.react.raw._
       |import japgolly.scalajs.react.vdom._
       |import org.scalajs.dom
       |import scala.scalajs.js
       |import scala.scalajs.js.`|`
       |
       |/**
       | * This file is generated - submit issues instead of PR against it
       | */
    """.stripMargin

  def destinationPathFor(outputPath: Path, prefixOpt: Option[String], comp: CompName): Path = {
    val baseFile = comp.value + ".scala"
    val filename = prefixOpt.fold(baseFile)(_ + baseFile)
    outputPath / filename
  }

  def foundComponentsFor(library: Library): Seq[FoundComponent] = {
    val visited = mutable.HashSet.empty[Path]

    def flattenScan(r: Required): Seq[FoundComponent] =
      r match {
        case NotFound(path) =>
          System.err.println(s"not found required path: $path")
          Seq.empty

        case Single(n, c) =>
          Seq(c)

        case Multiple(path, rs) =>
          if (visited.contains(path)) {
            Seq.empty
          } else {
            visited += path
            val requireds: Seq[Required] = rs.map(_.run).toList
            val recursive: Seq[FoundComponent] = requireds flatMap flattenScan
            System.err.println(s"Found in path $path: ${recursive.map(_.name.value)}")

            recursive
          }
      }

    library.locations.map(requiresjs.Require(_, library.indexNames)).flatMap(flattenScan)
  }

  def apply(library: Library, outputFolder: Path) = {
    val foundComponents: Seq[FoundComponent] = foundComponentsFor(library)

    val allFound: Map[CompName, FoundComponent] = foundComponents.map(c => c.name -> c).toMap

    val (mainFiles: Seq[PrimaryOutFile], secondaryFiles: Seq[SecondaryOutFile]) =
      library.components.foldLeft((Seq.empty[PrimaryOutFile], Seq.empty[SecondaryOutFile])) {
        case ((ps, ss), c) =>

          val parsed: ParsedComponent = ParseComponent(allFound, library, c)

          val (primaryFile, secondaryFile) = Printer(library.prefixOpt.getOrElse(""), parsed)

          (ps :+ primaryFile, ss ++ secondaryFile)
      }

    val fullOutputPath = outputFolder / RelPath(library.packageName.replaceAll("\\.", File.separator))
    fullOutputPath.toIO.mkdirs()

    val prelude: String =
      preludeFor(library)

    printToFile(fullOutputPath / "gen-types.scala") {
      w =>
        w.println(prelude)
        secondaryFiles.sortBy(_.content).distinct.foreach {
          case file =>
            w.println(file.content)
            w.println("")
        }
    }

    mainFiles foreach {
      case PrimaryOutFile(compName, content, secondaries) =>
        printToFile(destinationPathFor(fullOutputPath, library.prefixOpt, compName)) {
          w =>
            w.println(prelude + content)
            secondaries.foreach {
              case SecondaryOutFile(_, c) =>
                w.println("")
                w.println(c)
            }
        }
    }
  }
}