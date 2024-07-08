package chapter09

object Test14_HighLevelFunction {
  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4, 5, 6, 7, 8)

    //1. 过滤
    //选取偶数
    val evenList = list.filter( (elem: Int) => {elem % 2 == 0} )
    println(evenList)   //List(2, 4, 6, 8)
    println(list.filter( _ % 2== 1)) //选取奇数

    //2. map
    //集合每个数乘2
    println(list.map( _ * 2))  //List(2, 4, 6, 8, 10, 12, 14, 16)
    println(list.map( x => x * x))  //两个相同的x不可省略

    //3. 扁平化
    val nestedList: List[List[Int]] = List(List(1,2,3), List(4,5,6), List(7,8,9))
    val flatList = nestedList(0) ::: nestedList(1) ::: nestedList(2)
    println(flatList)  //List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val flatList2 = nestedList.flatten
    println(flatList2) //List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    //4. 扁平映射
    val wordList: List[String] = List("hello world", "hello scala", "hello java")
    val splitList: List[Array[String]] = wordList.map( _.split(" "))
    val flattenList = splitList.flatten
    println(flattenList) //List(hello, world, hello, scala, hello, java)

    val flatMapList = wordList.flatMap(_.split(" "))
    println(flatMapList) //List(hello, world, hello, scala, hello, java)

    //5. 分组groupBy
    //分成奇偶两组
    val groupMap: Map[Int, List[Int]] = list.groupBy( _ % 2 )
    val groupMap2: Map[String, List[Int]] = list.groupBy( data => if (data % 2 == 0) "偶数" else "奇数" )
    println(groupMap) //HashMap(0 -> List(2, 4, 6, 8), 1 -> List(1, 3, 5, 7))
    println(groupMap2) //HashMap(偶数 -> List(2, 4, 6, 8), 奇数 -> List(1, 3, 5, 7))

    //给定一组词汇，按照单词的首字母进行分组
    val wordList2 = List("China", "alice", "cary", "bob", "america", "canada")
    println(wordList2.groupBy( _.charAt(0) )) //按首字母
    //HashMap(a -> List(alice, america), b -> List(bob), C -> List(China), c -> List(cary, canada))


  }
}
