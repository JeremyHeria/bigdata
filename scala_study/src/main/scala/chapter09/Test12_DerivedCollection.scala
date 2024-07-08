package chapter09

object Test12_DerivedCollection {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 6, 34, 99)
    val list2 = List(33, 2, 65, 34, 78)
    //    （1）获取集合的头
    println(list1.head)   //1
    //    （2）获取集合的尾（不是头的就是尾） 得到的是新的list，只去除了第一个值
    println(list1.tail)   //List(2, 6, 34, 99)
    //    （3）集合最后一个数据
    println(list1.last)   //99
    //    （4）集合初始数据（不包含最后一个）
    println(list1.init)  //List(1, 2, 6, 34)
    //    （5）反转
    println(list1.reverse)  //List(99, 34, 6, 2, 1)
    //    （6）取前（后）n 个元素
    println(list1.take(3))  //前n个
    println(list1.takeRight(3)) //后m个
    //    （7）去掉前（后）n 个元素
    println(list1.drop(1))   //去掉前n个
    println(list2.dropRight(1))  //去掉后n个
    //    （8）并集
    val union = list1.union(list2)
    println("union " + union)
    println(list1 ::: list2)
    //union List(1, 2, 6, 34, 99, 33, 2, 65, 34, 78)
    //List(1, 2, 6, 34, 99, 33, 2, 65, 34, 78)
    //set合并会去重 set1.union(set2) set1 ++ set2
    val set1 = Set(1, 2, 6, 34, 99)
    val set2 = Set(33, 2, 65, 34, 78)
    val union2 = set1.union(set2)
    //union2: Set(5,89,1,2,45,7,3,8,19,4)
    //    （9）交集
    val intersection = list1.intersect(list2)
    println("intersection " + intersection)
    //intersection List(2, 34)
    //    （10）差集
    val diff1 = list1.diff(list2)
    val diff2 = list2.diff(list1)
    println("diff1 " + diff1)
    println("diff2 " + diff2)
    //diff1 List(1, 6, 99)
    //diff2 List(33, 65, 78)
    //    （11）拉链
    println(list1.zip(list2)) //一一对应形成二元组，多余的不输出
    //List((1,33), (2,2), (6,65), (34,34), (99,78))
    //    （12）滑窗
    println(list1.sliding(3).foreach(println))
    //List(1, 2, 6)
    //List(2, 6, 34)
    //List(6, 34, 99)
    //()
    println(list1.sliding(3, 2).foreach(println))  //窗口长度，步长
    //窗口长度和步长相同就形成了滚动窗口
    //List(1, 2, 6)
    //List(6, 34, 99)
    //()
      }
}
