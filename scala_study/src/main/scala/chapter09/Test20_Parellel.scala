package chapter09

import scala.collection.immutable
import scala.collection.parallel.immutable

object Test20_Parellel {
  def main(args: Array[String]): Unit = {
    //���߳�
    val result  = (1 to 100).map(

      //���ID����ͬ
      x => Thread.currentThread.getId
    )
    println(result)
    //Vector(1, 1, 1, ����)

    //���м���
    val result2 = (1 to 100).par.map(

      //����߳�ID�����ֲ�ͬ�߳��ڴ���
      x => Thread.currentThread.getId
    )
    println(result2)
    //ParVector(20, 20, 20, 20, 30, ����) �ɲ�ͬ�߳�ִ��
  }
 }
