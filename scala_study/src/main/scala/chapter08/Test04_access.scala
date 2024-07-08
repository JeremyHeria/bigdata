package chapter08

object Test04_access {

  def main(args: Array[String]): Unit ={//创建对象
    val person: Person = new Person()
      //person.idCard    //error,私有属性只在自己类的内部和伴生对象中可用
      //person.name      //error,同类、子类可以访问，同包无法访问
      println(person.age)
    println(person.sex)
  }
}
class Worker extends Person{
  println("worker:")
  //println(idCard)   //私有属性只在自己类的内部和伴生对象中可用
  name="bob"
  age=25
  sex="male"
}