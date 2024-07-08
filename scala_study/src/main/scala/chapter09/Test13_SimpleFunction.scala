package chapter09

object Test13_SimpleFunction {
  def main(args: Array[String]): Unit = {
    val list = List(21, 4, 65, 2, -7)
    val list2 = List(("a", 3), ("b", 1), ("d", 9), ("f", 10))
    //    （1）求和
    println(list.sum)
    //    （2）求乘积
    println(list.product)
    //    （3）最大值
    println(list.max)
    println(list2.max) //(f,10)  默认按元组的第一个元素去取最大
    println(list2.maxBy((tuple: (String, Int)) => tuple._2)) //(f,10)  指定按第二个元素排序
    println(list2.maxBy( _._2) ) //(f,10)
    //    （4）最小值
    println(list.min)
    println(list2.minBy(_._2))
    //    （5）排序
    //5.1 sorted
    val sortedList = list.sorted
    println(sortedList)   //List(-7, 2, 4, 21, 65)
    //从大到小排列 list.sorted.reverse
    //使用隐式参数
    println(list.sorted(Ordering[Int].reverse))
    println(list2.sorted)  //按第一个元素

    //5.2 sortBy
    println(list2.sortBy(_._2)) //List((b,1), (a,3), (d,9), (f,10))
    println(list2.sortBy(_._2)(Ordering[Int].reverse)) //List((f,10), (d,9), (a,3), (b,1))

    //5.3 sortWith
    println(list.sortWith( (a: Int, b: Int) => {a < b}))  //从小打到排序
    println(list.sortWith( _ < _ )) //从小到大排序
    println(list.sortWith(( _ > _))) //从大到小排序
      }

}
