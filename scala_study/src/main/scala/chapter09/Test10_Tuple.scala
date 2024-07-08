package chapter09

object Test10_Tuple {
  def main(args: Array[String]): Unit = {
    //1. 创建元组
    val tuple: (String, Char, Int, Boolean) = ("hello", 'a',  12, false) //类型需要一一对应
    println(tuple) //(hello,a,12,false)

    //2. 访问数据
    println(tuple._1) //hello
    println(tuple._2) //a
    println(tuple._3) //12

    println(tuple.productElement(1))  //返回相应索引位置的元素

    //3. 遍历元组
    for (elem <- tuple.productIterator) {println(elem)}  //依次打印

    //4. 嵌套元组
    val mulTuple = (12, 0.9, (9, "h"), 20)
    println(mulTuple._3)
    //(9,h)
  }
}
