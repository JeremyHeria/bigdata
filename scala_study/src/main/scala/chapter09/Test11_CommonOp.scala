package chapter09

object Test11_CommonOp {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 6, 34)
    val set = Set(23, 45, 1, 77)
    //    （1）获取集合长度
    println(list.length)  //4
    //    （2）获取集合大小
    println(set.size)     //4
    //    （3）循环遍历
    for (elem <- list) {
      println(elem)
    }
    set.foreach(println)
    //    （4）迭代器
    for (elem <- set.iterator) println(elem)
    //    （5）生成字符串
    println(list)  //List(1, 2, 6, 34)
    println(set)   //Set(23, 45, 1, 77)
    println(list.mkString("--"))   //1--2--6--34
    //    （6）是否包含
    println(list.contains(2))  //true
    println(set.contains(3))   //false
     }
}
