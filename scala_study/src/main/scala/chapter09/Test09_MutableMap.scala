package chapter09

import scala.collection.mutable

object Test09_MutableMap {
  def main(args: Array[String]): Unit = {
    val map1 = mutable.Map("a" -> 12, "b" -> 5, "hello" -> 3)
    println(map1)
    println(map1.getClass)
    //HashMap(a -> 12, b -> 5, hello -> 3)
    //class scala.collection.mutable.HashMap

    //2. 添加元素
    map1.put("c", 4)
    map1.put("d", 8)
    println(map1)
    //HashMap(a -> 12, b -> 5, c -> 4, hello -> 3, d -> 8)
    map1 += (("e", 4))

    //3. 删除元素
    map1.remove("a")
    println(map1)  //HashMap(b -> 5, c -> 4, d -> 8, e -> 4, hello -> 3)
    map1 -= "hello"
    println(map1)  //HashMap(b -> 5, c -> 4, d -> 8, e -> 4)

    //4. 修改元素
    map1("a") = 2  //未出现的相当于添加
    map1("b") = 4  //修改
    println(map1)  //HashMap(a -> 2, b -> 4, c -> 4, d -> 8, e -> 4)

    //5. 合并Map
    val map2 = mutable.Map("d" -> 12, "b" -> 99, "k" -> 3)
    map1 ++= map2
    println(map1)  //HashMap(a -> 2, b -> 99, c -> 4, d -> 12, e -> 4, k -> 3)
    //map2中的元素添加到map1中，未出现过的直接添加，出现过的覆盖
    //不可变集合也可以与可变集合合并，但要赋值给新的不可变map

  }

}
