package chapter08

object Test09_AbstractClass {
  def main(args: Array[String]): Unit = {

  }

}
//���������
abstract class Person9{
  //�ǳ�������
  val name:String = "Person"
  //��������
  var age:Int

  //�ǳ��󷽷�
  def eat():Unit={
    println("person eat")
  }
  //���󷽷�
  def sleep():Unit
}

//�������ʵ�ֵ�����
class Student9 extends Person9{
  var age:Int = 18
  def sleep():Unit={
    println("student sleep")
  }

  //��д�ǳ������Ժͷ���
  override def eat(): Unit = {
    println("student eat")
  }
}
