package chapter09

import scala.collection.mutable.ListBuffer

object Test05_ListBuffer {
  def main(args: Array[String]): Unit = {
    val list1 = new ListBuffer[Int]()//此时arr1为空
    val list2 =ListBuffer(23,67)
    list1.append(156)//加在最后
    list1.prepend(19)//加载最前
    list1.insert(1,19,22)//指定位置
    31 +=:90 +=: 300 +=: list1 += 25 += 49
    println(list1)
    list1 ++= list2
    val list3 = list1 ++ list2
  }
}
