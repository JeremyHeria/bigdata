package chapter09

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.mutable

object Test02_ArrayBuffer {
  def main(args: Array[String]) = {

    val arr =ArrayBuffer(23,67)
    val newArr = arr.toArray
    println(newArr)
    val buffer = newArr.toBuffer
    println(buffer)
  }

}
