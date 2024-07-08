package chapter10

object Test01_PatternMatchBase {
  def main(args: Array[String]): Unit = {

    //1.ƥ�䳣��
    def describeConst(x: Any): String = x match {
      case 1 => "Int 1"
      case "hello" => "String hello"
      case true => "Boolean true"
      case '+' => "Char +"
      case _ => ""
    }

    println(describeConst(0.1))
    println(describeConst("hello")) //String hello
    println(describeConst(true)) //Boolean true

    //2. ƥ������
    def describeType(x: Any): String = x match {
      case i: Int => "Int " + i
      case s: String => "String " + s
      case list: List[String] => "List " + list
      case array: Array[Int] => "Array[Int] " + array.mkString(",")
      case a => "Something else " + a //���ﲻʹ��ͨ�����Ϊ�˻�ȡ�������ֵ
    }

    println(describeType(7)) //Int 7
    println(describeType("hello")) //String hello
    println(describeType(List("hi", "hello"))) //List List(hi, hello)
    println(describeType(List(2, 3))) //List List(2, 3)
    //���ﲻƥ��List�ķ��ͣ�ƥ��ʱ������
    // �������⣬�ɱ�������
    println(describeType(Array("hi", "hello"))) //Something else [Ljava.lang.String;@d7b1517
    println(describeType(Array(4, 5))) //Array[Int] 4,5

    //3. ƥ������
    for (arr <- List(
      Array(0),
      Array(1, 0),
      Array(0, 1, 0),
      Array(1, 1, 0),
      Array(2, 3, 7, 29),
      Array("hello", 20, 30)
    )) {
      val result = arr match {
        case Array(0) => "0"
        case Array(1, 0) => "Array(1, 0)"
        case Array(x, y) => "Array: " + x + ", " + y //ƥ����Ԫ������
        case Array(0, _*) => "��0��ͷ������"
        case Array(x, 1, z) => "�ڶ���Ԫ��Ϊ1����Ԫ������"
        case _ => "something else"
      }
      println(result)
      //0
      //Array(1, 0)
      //��0��ͷ������
      //�ڶ���Ԫ��Ϊ1����Ԫ������
      //something else
      //something else
    }

    //4. ƥ���б�
    // ��ʽһ
    for (list <- List(
      List(0),
      List(1, 0),
      List(1, 1, 0),
      List(0, 3, 5),
      List("hello")
    )){
      val result = list match {
        case List(0) => "0"
        case List(x, y) => "List(x, y): " + x + ", " + y
        case List(1, _*) => "List(1, ����)"
        case List(a) => "List(a): " + a
        case _ => "something else"
      }
      println(result)
      //0
      //List(x, y): 1, 0
      //List(1, ����)
      //something else
      //List(a): hello
    }
    //��ʽ��
    val list = List(1, 2, 5, 7, 8)
    list match{
      case first :: second :: rest => println(s"first: $first, second $second, rest $rest")
      case _ => println("else")
    }
    //first: 1, second 2, rest List(5, 7, 8)  ��Ҫ��������Ԫ�ز���ƥ����

    //5. ƥ��Ԫ��
    for (tuple <- List(
      (0, 1),
      (0, 0),
      (0, 1, 0),
      (0, 1, 1),
      (1, 22, 44)
    )){
      val result = tuple match{
        case (a, b) => a + ", " + b
        case (0, _) => "(0, _)"
        case (a, 1, _) => "(a, 1, _) " + a
        case (x, y, z) => "(x, y, z): " + x + ", " + y + ", " +z
        case _ => "else"
      }
      println(result)
      //0, 1
      //0, 0
      //(a, 1, _) 0
      //(a, 1, _) 0
      //(x, y, z): 1, 22, 44
    }

    //Ԫ��ƥ����չ
    //5.1 �ڱ�������ʱƥ��
    val (x, y) = (10, "hello")
    println(s"x: $x, y: $y")  //x: 10, y: hello

    val List(first, second, _*) = List(23, 1, 3, 56)
    println(s"first: $first, second: $second")
    //first: 23, second: 1

    val fir :: sec :: rest = List(1, 2, 3, 4, 6)
    println(s"first: $fir, second: $sec, rest: $rest")
    //first: 1, second: 2, rest: List(3, 4, 6)

    //5.2 for�Ƶ�ʽ�н���ģʽƥ��
    val list1: List[(String, Int)] = List(("a", 12), ("b", 13), ("c", 34), ("a", 34))

    //(1)ԭ���ı�����ʽ
    for (elem <- list1) println(elem._1 + ", " + elem._2) //a, 12  b, 13  c, 34

    //(2)��list��Ԫ��ֱ�Ӷ���ΪԪ�飬�Ա�����ֵ
    for ((word, count) <- list1) println(word + ", " + count)

    //(3) ������ĳ��λ�õı�����ֻ����key����value
    for ((word, _) <- list1) println(word)

    //(4)ָ��ĳ��λ�õ�ֵ
    for (("a", count) <- list1) println(count)  //12  34
  }

}
