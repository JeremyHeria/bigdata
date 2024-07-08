package chapter09

object Test01_ImmutableArray {
  def main(args: Array[String]): Unit = {
    var arr1:Array[Int] = new Array[Int](5)
    println(arr1(0))//0
    println(arr1(3))//0
    println(arr1(4))//0
    println(arr1(5))//error

    for(elem<- arr1) println(arr1(elem))

    val iter = arr1.iterator
    while (iter.hasNext)
      println(iter.next())

    arr1.foreach(println)
  }
}
