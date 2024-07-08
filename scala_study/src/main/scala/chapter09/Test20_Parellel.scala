package chapter09

import scala.collection.immutable
import scala.collection.parallel.immutable

object Test20_Parellel {
  def main(args: Array[String]): Unit = {
    //单线程
    val result  = (1 to 100).map(

      //输出ID都相同
      x => Thread.currentThread.getId
    )
    println(result)
    //Vector(1, 1, 1, ……)

    //并行计算
    val result2 = (1 to 100).par.map(

      //输出线程ID，发现不同线程在处理
      x => Thread.currentThread.getId
    )
    println(result2)
    //ParVector(20, 20, 20, 20, 30, ……) 由不同线程执行
  }
 }
