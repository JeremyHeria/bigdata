package chapter09

object Test17_CommonWordCount {
  def main(args: Array[String]): Unit = {
    val stringList: List[String] = List(
      "hello",
      "hello world",
      "hello scala",
      "hello scala",
      "hello spark from scala",
      "hello flink from scala"
    )
    //1.���ַ��������з֣��õ�һ����ɢ���е��ʵ��б�
    val wordList=stringList.flatMap(_.split(" "))
    println(wordList)

    //2.��ͬ���ʽ��з������
    val groupMap: Map[String, List[String]] = wordList.groupBy(word => word)
    println(groupMap)

    //3.�Է���֮����б�ȡ���ȣ��õ�ÿ�����ʵĸ���(������Ϊkey�����ȱ�Ϊvalue)
    val countMap: Map[String, Int] = groupMap.map(kv => (kv._1, kv._2.length))

    //4.��mapת��Ϊlist������ȡǰ��
    val sortList: List[(String, Int)] = countMap.toList
      //�Ӵ�С����
      .sortWith(_._2 >_._2)
      //ȡǰ��
      .take(3)
  }
}
