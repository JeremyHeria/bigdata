package chapter09

object Test08_ImmutableMap {
  def main(args: Array[String]): Unit = {
    //1. 创建map
    val map1: Map[String, Int] = Map("a" -> 12, "b" -> 5, "hello" -> 3)
    println(map1)
    println(map1.getClass)
    //Map(a -> 12, b -> 5, hello -> 3)
    //class scala.collection.immutable.Map$Map3

    //2. 遍历元素
    map1.foreach(println)
    //map1.foreach( (kv: (String, Int)) => println(kv) )
    //(a,12)
    //(b,5)
    //(hello,3)

    //3. 取map中所有的 key 或 value
    for (key <- map1.keys) {
      println(s"$key ---> ${map1.get(key)}")
    }
    //a ---> Some(12)
    //b ---> Some(5)
    //hello ---> Some(3)

    //4. 访问某一个key的value
    println(map1.get("a").get)  //12
    println(map1.get("c"))      //None
    println(map1.getOrElse("c", 0)) //防止为空时get抛出异常   若为None返回0
    //0
      }
}
