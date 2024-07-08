package chapter09

object Test14_HighLevelFunction {
  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4, 5, 6, 7, 8)

    //1. ����
    //ѡȡż��
    val evenList = list.filter( (elem: Int) => {elem % 2 == 0} )
    println(evenList)   //List(2, 4, 6, 8)
    println(list.filter( _ % 2== 1)) //ѡȡ����

    //2. map
    //����ÿ������2
    println(list.map( _ * 2))  //List(2, 4, 6, 8, 10, 12, 14, 16)
    println(list.map( x => x * x))  //������ͬ��x����ʡ��

    //3. ��ƽ��
    val nestedList: List[List[Int]] = List(List(1,2,3), List(4,5,6), List(7,8,9))
    val flatList = nestedList(0) ::: nestedList(1) ::: nestedList(2)
    println(flatList)  //List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val flatList2 = nestedList.flatten
    println(flatList2) //List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    //4. ��ƽӳ��
    val wordList: List[String] = List("hello world", "hello scala", "hello java")
    val splitList: List[Array[String]] = wordList.map( _.split(" "))
    val flattenList = splitList.flatten
    println(flattenList) //List(hello, world, hello, scala, hello, java)

    val flatMapList = wordList.flatMap(_.split(" "))
    println(flatMapList) //List(hello, world, hello, scala, hello, java)

    //5. ����groupBy
    //�ֳ���ż����
    val groupMap: Map[Int, List[Int]] = list.groupBy( _ % 2 )
    val groupMap2: Map[String, List[Int]] = list.groupBy( data => if (data % 2 == 0) "ż��" else "����" )
    println(groupMap) //HashMap(0 -> List(2, 4, 6, 8), 1 -> List(1, 3, 5, 7))
    println(groupMap2) //HashMap(ż�� -> List(2, 4, 6, 8), ���� -> List(1, 3, 5, 7))

    //����һ��ʻ㣬���յ��ʵ�����ĸ���з���
    val wordList2 = List("China", "alice", "cary", "bob", "america", "canada")
    println(wordList2.groupBy( _.charAt(0) )) //������ĸ
    //HashMap(a -> List(alice, america), b -> List(bob), C -> List(China), c -> List(cary, canada))


  }
}
