package com.github.rojanu

import java.io.FileNotFoundException

import scala.io.{Codec, Source}
import scala.util.{Failure, Success, Try}

trait ResourceHelper {
  implicit val codec: Codec = Codec("UTF-8")

  def loadFixtureFile(path: String): String = {
    Try(Source.fromURL(getClass.getResource(path))) match {
      case Success(source) =>
        val result = source.mkString
        source.close
        result
      case Failure(error) =>
        println(error.getMessage)
        error.printStackTrace()
        throw new FileNotFoundException(path)
    }
  }
}
