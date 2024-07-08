package chapter09

object Test10_Tuple {
  def main(args: Array[String]): Unit = {
    //1. ����Ԫ��
    val tuple: (String, Char, Int, Boolean) = ("hello", 'a',  12, false) //������Ҫһһ��Ӧ
    println(tuple) //(hello,a,12,false)

    //2. ��������
    println(tuple._1) //hello
    println(tuple._2) //a
    println(tuple._3) //12

    println(tuple.productElement(1))  //������Ӧ����λ�õ�Ԫ��

    //3. ����Ԫ��
    for (elem <- tuple.productIterator) {println(elem)}  //���δ�ӡ

    //4. Ƕ��Ԫ��
    val mulTuple = (12, 0.9, (9, "h"), 20)
    println(mulTuple._3)
    //(9,h)
  }
}
