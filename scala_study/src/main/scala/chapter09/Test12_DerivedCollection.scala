package chapter09

object Test12_DerivedCollection {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 6, 34, 99)
    val list2 = List(33, 2, 65, 34, 78)
    //    ��1����ȡ���ϵ�ͷ
    println(list1.head)   //1
    //    ��2����ȡ���ϵ�β������ͷ�ľ���β�� �õ������µ�list��ֻȥ���˵�һ��ֵ
    println(list1.tail)   //List(2, 6, 34, 99)
    //    ��3���������һ������
    println(list1.last)   //99
    //    ��4�����ϳ�ʼ���ݣ����������һ����
    println(list1.init)  //List(1, 2, 6, 34)
    //    ��5����ת
    println(list1.reverse)  //List(99, 34, 6, 2, 1)
    //    ��6��ȡǰ����n ��Ԫ��
    println(list1.take(3))  //ǰn��
    println(list1.takeRight(3)) //��m��
    //    ��7��ȥ��ǰ����n ��Ԫ��
    println(list1.drop(1))   //ȥ��ǰn��
    println(list2.dropRight(1))  //ȥ����n��
    //    ��8������
    val union = list1.union(list2)
    println("union " + union)
    println(list1 ::: list2)
    //union List(1, 2, 6, 34, 99, 33, 2, 65, 34, 78)
    //List(1, 2, 6, 34, 99, 33, 2, 65, 34, 78)
    //set�ϲ���ȥ�� set1.union(set2) set1 ++ set2
    val set1 = Set(1, 2, 6, 34, 99)
    val set2 = Set(33, 2, 65, 34, 78)
    val union2 = set1.union(set2)
    //union2: Set(5,89,1,2,45,7,3,8,19,4)
    //    ��9������
    val intersection = list1.intersect(list2)
    println("intersection " + intersection)
    //intersection List(2, 34)
    //    ��10���
    val diff1 = list1.diff(list2)
    val diff2 = list2.diff(list1)
    println("diff1 " + diff1)
    println("diff2 " + diff2)
    //diff1 List(1, 6, 99)
    //diff2 List(33, 65, 78)
    //    ��11������
    println(list1.zip(list2)) //һһ��Ӧ�γɶ�Ԫ�飬����Ĳ����
    //List((1,33), (2,2), (6,65), (34,34), (99,78))
    //    ��12������
    println(list1.sliding(3).foreach(println))
    //List(1, 2, 6)
    //List(2, 6, 34)
    //List(6, 34, 99)
    //()
    println(list1.sliding(3, 2).foreach(println))  //���ڳ��ȣ�����
    //���ڳ��ȺͲ�����ͬ���γ��˹�������
    //List(1, 2, 6)
    //List(6, 34, 99)
    //()
      }
}
