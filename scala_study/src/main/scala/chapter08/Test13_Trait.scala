package chapter08

object Test13_Trait {
  def main(args: Array[String]): Unit = {
    val student = new Student13 with Young{
      //��д��ͻ������
      override val name: String ="heria"

      def dating():Unit = println(s"student $name is dating")
      def study():Unit = println(s"student $name is studying")
    }

    student.sayHello()
//    hello from:heria
//    hello from :student heria
    student.study()//student heria is studying
    student.play()//young people can play
  }
}
class Person13{
  val name:String = "person"
  var age:Int = 18
  def sayHello():Unit={
    println("hello from:" +name)
  }
}
//��������
trait Young{
  //��������ͷǳ�������
  var age:Int
  val name:String = "young"

  def play():Unit = {
    println("young people can play")
  }
  def dating():Unit
}
class Student13 extends Person13{

  //��д���෽��
  override def sayHello(): Unit = {
    super.sayHello()
    println(s"hello from :student $name")
  }
}