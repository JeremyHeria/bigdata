package chapter08

object Test05_Constructor {
  def main(args: Array[String]): Unit = {
    val student1 = new Student()
    student1.Student()
    //主构造方法被调用
    //一般方法被调用

    val student2 = new Student("alice")
    //主构造方法被调用
    //辅助构造器一被调用
    //name:alice age: 0

    val student3 = new Student("alice",25)
    //主构造方法被调用
    //辅助构造器一被调用
    //name:alice age: 0
    //辅助构造方法二被调用
    //name:alice age: 25
  }
}

//定义一个类
class Student{
  //定义属性
  var name:String= _
  var age:Int= _
  println("主构造方法被调用")

  //声明辅助构造方法
  //辅助构造器一
  def this(name:String){
    this()  //直接调用主构造器
    println("辅助构造器一被调用")
    this.name=name
    println(s"name:$name age: $age")
  }
  //辅助构造器二
  def this(name : String,age: Int) {
    this(name)
    println("辅助构造方法二被调用")
    this.age= age
    println(s"name:$name age: $age")
  }

  //一般方法
  def Student():Unit={
    println("一般方法被调用")
  }
}
