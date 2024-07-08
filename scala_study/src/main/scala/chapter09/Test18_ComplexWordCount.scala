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

    //1.�����е�Ԫ�鰴�յ��ʲ𿪸����ӵ�ͳ�ƴ�����ϳ�һ��Ԫ��
    val preCountList: List[(String,Int)] = tupleList.flatMap(
      tuple =>{
        //���ַ������ո�����з�
        val strings: Array[String] = tuple._1.split(" ")
        //�ѵ��ʺ�ͳ��������ϳ�Ԫ��
        strings.map(word =>(word,tuple._2))
      }
    )

    //2.�Զ�Ԫ�鰴�յ��ʽ��з���
    val preCountMap: Map[String, List[(String, Int)]] = preCountList.groupBy(_._1)

    //3.����ÿ������Ԥͳ�Ƶĸ���ֵ
    val countMap: Map[String, Int] = preCountMap.mapValues(
      tupleList => tupleList.map(_._2).sum
    )

    //4.ת����list������ȡǰ��
    val countList = countMap.toList
      .sortWith(_._2 >_._2)
      .take(3)
    println(countList)



  }
}
