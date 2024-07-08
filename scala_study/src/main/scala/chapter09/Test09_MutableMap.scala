package chapter09

import scala.collection.mutable

object Test09_MutableMap {
  def main(args: Array[String]): Unit = {
    val map1 = mutable.Map("a" -> 12, "b" -> 5, "hello" -> 3)
    println(map1)
    println(map1.getClass)
    //HashMap(a -> 12, b -> 5, hello -> 3)
    //class scala.collection.mutable.HashMap

    //2. ���Ԫ��
    map1.put("c", 4)
    map1.put("d", 8)
    println(map1)
    //HashMap(a -> 12, b -> 5, c -> 4, hello -> 3, d -> 8)
    map1 += (("e", 4))

    //3. ɾ��Ԫ��
    map1.remove("a")
    println(map1)  //HashMap(b -> 5, c -> 4, d -> 8, e -> 4, hello -> 3)
    map1 -= "hello"
    println(map1)  //HashMap(b -> 5, c -> 4, d -> 8, e -> 4)

    //4. �޸�Ԫ��
    map1("a") = 2  //δ���ֵ��൱�����
    map1("b") = 4  //�޸�
    println(map1)  //HashMap(a -> 2, b -> 4, c -> 4, d -> 8, e -> 4)

    //5. �ϲ�Map
    val map2 = mutable.Map("d" -> 12, "b" -> 99, "k" -> 3)
    map1 ++= map2
    println(map1)  //HashMap(a -> 2, b -> 99, c -> 4, d -> 12, e -> 4, k -> 3)
    //map2�е�Ԫ����ӵ�map1�У�δ���ֹ���ֱ����ӣ����ֹ��ĸ���
    //���ɱ伯��Ҳ������ɱ伯�Ϻϲ�����Ҫ��ֵ���µĲ��ɱ�map

  }

}
