package chapter09

import scala.collection.immutable.Queue
import scala.collection.mutable

object Test19_Queue {
  def main(args: Array[String]): Unit = {
    //创建一个可变队列
    val queue: mutable.Queue[String] = new mutable.Queue[String]()
    queue.enqueue("a", "b", "c")
    println(queue)  //Queue(a, b, c)
    println(queue.dequeue()) //a
    println(queue)  //Queue(b, c)

    //创建一个不可变队列
    val queue2:Queue[String] = Queue("a", "b", "c")
    queue2.enqueue("d")
    println(queue2)  //Queue(a, b, c)  并未改变
    val queue3 = queue2.enqueue("d")
    println(queue3)  //Queue(a, b, c, d)
  }
}
