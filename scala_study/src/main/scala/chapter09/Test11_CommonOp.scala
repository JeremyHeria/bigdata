package chapter09

object Test11_CommonOp {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 6, 34)
    val set = Set(23, 45, 1, 77)
    //    ��1����ȡ���ϳ���
    println(list.length)  //4
    //    ��2����ȡ���ϴ�С
    println(set.size)     //4
    //    ��3��ѭ������
    for (elem <- list) {
      println(elem)
    }
    set.foreach(println)
    //    ��4��������
    for (elem <- set.iterator) println(elem)
    //    ��5�������ַ���
    println(list)  //List(1, 2, 6, 34)
    println(set)   //Set(23, 45, 1, 77)
    println(list.mkString("--"))   //1--2--6--34
    //    ��6���Ƿ����
    println(list.contains(2))  //true
    println(set.contains(3))   //false
     }
}
