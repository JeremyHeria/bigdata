package chapter09

import scala.collection.mutable.ListBuffer

object Test05_ListBuffer {
  def main(args: Array[String]): Unit = {
    val list1 = new ListBuffer[Int]()//��ʱarr1Ϊ��
    val list2 =ListBuffer(23,67)
    list1.append(156)//�������
    list1.prepend(19)//������ǰ
    list1.insert(1,19,22)//ָ��λ��
    31 +=:90 +=: 300 +=: list1 += 25 += 49
    println(list1)
    list1 ++= list2
    val list3 = list1 ++ list2
  }
}
