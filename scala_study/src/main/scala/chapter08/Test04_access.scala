package chapter08

object Test04_access {

  def main(args: Array[String]): Unit ={//��������
    val person: Person = new Person()
      //person.idCard    //error,˽������ֻ���Լ�����ڲ��Ͱ��������п���
      //person.name      //error,ͬ�ࡢ������Է��ʣ�ͬ���޷�����
      println(person.age)
    println(person.sex)
  }
}
class Worker extends Person{
  println("worker:")
  //println(idCard)   //˽������ֻ���Լ�����ڲ��Ͱ��������п���
  name="bob"
  age=25
  sex="male"
}