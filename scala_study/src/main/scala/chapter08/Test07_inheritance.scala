package chapter08

object Test07_inheritance {
  def main(args: Array[String]): Unit = {
    val student1 = new Student7("alice",18)
    //1.�����������������
    //3.�����������������
    println("--------------")
    val student2 = new Student7("alice",18,"std001")
    //1.�����������������
    //3.�����������������
    //4.����ĸ�������������
  }
}
class Person7(){
  var name:String= _
  var age:Int = _
  println("1.�����������������")
  def this(name:String,age:Int){
    this()
    println("2.����ĸ�������������")
    this.name = name
    this.age = age
  }
  def printInfo():Unit = {
    println(s"Person:$name $age")
  }
}
class Student7(name:String,age:Int) extends Person7{
  var stdNo:String = _
  println("3.�����������������")
  def this(name:String,age:Int,stdNo:String){
    this(name,age)
    println("4.����ĸ�������������")
    this.stdNo=stdNo
  }

  override def printInfo(): Unit = {
    println(s"Person:$name $age $stdNo")
  }
}
