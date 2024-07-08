package chapter08

object Test09_AbstractClass {
  def main(args: Array[String]): Unit = {

  }

}
//定义抽象类
abstract class Person9{
  //非抽象属性
  val name:String = "Person"
  //抽象属性
  var age:Int

  //非抽象方法
  def eat():Unit={
    println("person eat")
  }
  //抽象方法
  def sleep():Unit
}

//定义具体实现的子类
class Student9 extends Person9{
  var age:Int = 18
  def sleep():Unit={
    println("student sleep")
  }

  //重写非抽象属性和方法
  override def eat(): Unit = {
    println("student eat")
  }
}
