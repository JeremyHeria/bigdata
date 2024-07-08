package chapter08

object Test06_ConstructorParams {
  def main(args: Array[String]): Unit = {
    val student5 = new Student5("bob",23)
    student5.printInfo()
  }
}

//定义类
//传参构造器
class Student5(name:String,age:Int){
  def printInfo(){
    println(s"student5:name=${name},age=$age")
  }
}
