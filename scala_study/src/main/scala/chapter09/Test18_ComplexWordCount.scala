package chapter09

object Test18_ComplexWordCount {
  def main(args: Array[String]): Unit = {
    val tupleList: List[(String,Int)] = List(
      ("hello", 1),
      ("hello world", 2),
      ("hello scala", 3),
      ("hello spark from scala", 1),
      ("hello flink from scala", 2)
    )

    //1.把所有的元组按照单词拆开跟句子的统计次数组合成一个元组
    val preCountList: List[(String,Int)] = tupleList.flatMap(
      tuple =>{
        //把字符串按空格进行切分
        val strings: Array[String] = tuple._1.split(" ")
        //把单词和统计数字组合成元组
        strings.map(word =>(word,tuple._2))
      }
    )

    //2.对二元组按照单词进行分组
    val preCountMap: Map[String, List[(String, Int)]] = preCountList.groupBy(_._1)

    //3.叠加每个单词预统计的个数值
    val countMap: Map[String, Int] = preCountMap.mapValues(
      tupleList => tupleList.map(_._2).sum
    )

    //4.转换成list，排序取前三
    val countList = countMap.toList
      .sortWith(_._2 >_._2)
      .take(3)
    println(countList)



  }
}
