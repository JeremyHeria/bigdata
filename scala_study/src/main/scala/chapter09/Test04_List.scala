package chapter09

object Test04_List {
  def main(args: Array[String]): Unit = {
    val list4 = Nil.::(31)
    val list5 = 17 :: 28 :: 59 ::78 ::Nil
    val list6 = list4 ::: list5
    println(list6)
  }


}
