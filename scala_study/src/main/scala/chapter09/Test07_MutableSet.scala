package chapter09

import scala.collection.mutable
import scala.reflect.internal.TreesStats.nodeByType.+=

object Test07_MutableSet {
  def main(args: Array[String]): Unit = {
    //1. 创建可变集合
    val set1: mutable.Set[Int] = mutable.Set(13, 24, 57, 36)
    println(set1)  //HashSet(24, 57, 36, 13)

    //2. 添加元素
    println(set1)  //HashSet(24, 57, 36, 13)
    set1 +=111
    println(set1)  //HashSet(24, 57, 36, 13, 111)
    set1.add(88)

    //3. 删除元素
    set1 -= 24
    set1.remove(57)
    println(set1) //HashSet(36, 88, 13, 111)

    //4. 合并两个Set
    val set3 = mutable.Set(22, 89, 45, 20)
    val set4 = set1 ++ set3
    println(set4) //HashSet(20, 36, 22, 88, 89, 13, 45, 111)
    set1 ++= set3   //set1元素与set4相同

      }
}
