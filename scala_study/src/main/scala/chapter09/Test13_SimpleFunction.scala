package chapter09

object Test13_SimpleFunction {
  def main(args: Array[String]): Unit = {
    val list = List(21, 4, 65, 2, -7)
    val list2 = List(("a", 3), ("b", 1), ("d", 9), ("f", 10))
    //    ��1�����
    println(list.sum)
    //    ��2����˻�
    println(list.product)
    //    ��3�����ֵ
    println(list.max)
    println(list2.max) //(f,10)  Ĭ�ϰ�Ԫ��ĵ�һ��Ԫ��ȥȡ���
    println(list2.maxBy((tuple: (String, Int)) => tuple._2)) //(f,10)  ָ�����ڶ���Ԫ������
    println(list2.maxBy( _._2) ) //(f,10)
    //    ��4����Сֵ
    println(list.min)
    println(list2.minBy(_._2))
    //    ��5������
    //5.1 sorted
    val sortedList = list.sorted
    println(sortedList)   //List(-7, 2, 4, 21, 65)
    //�Ӵ�С���� list.sorted.reverse
    //ʹ����ʽ����
    println(list.sorted(Ordering[Int].reverse))
    println(list2.sorted)  //����һ��Ԫ��

    //5.2 sortBy
    println(list2.sortBy(_._2)) //List((b,1), (a,3), (d,9), (f,10))
    println(list2.sortBy(_._2)(Ordering[Int].reverse)) //List((f,10), (d,9), (a,3), (b,1))

    //5.3 sortWith
    println(list.sortWith( (a: Int, b: Int) => {a < b}))  //��С������
    println(list.sortWith( _ < _ )) //��С��������
    println(list.sortWith(( _ > _))) //�Ӵ�С����
      }

}
