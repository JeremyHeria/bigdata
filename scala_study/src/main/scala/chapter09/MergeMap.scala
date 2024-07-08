package chapter09

import scala.collection.mutable

object MergeMap {
  def main(args: Array[String]): Unit = {

    val map1 = Map("a" -> 2, "b" -> 4, "c" -> 3)
    val map2 = mutable.Map("a" -> 4, "b" -> 1, "c" -> 2, "d" -> 9)

    val map3 = map1.foldLeft(map2)(  //����ֻ����foldLeft ������ֵͬ����fold
      (mergedMap, kv) => {   //��һ��������ʾ�ϲ���Ľ�����ڶ���������Ԫ��
        val key = kv._1
        val value = kv._2
        mergedMap(key) = mergedMap.getOrElse(key, 0) + value  //���ҳ��ֹ��ģ�������
        mergedMap
      }
    )
    println(map3)
    //HashMap(a -> 6, b -> 5, c -> 5, d -> 9)
     }
}
