package chapter08

object Test05_Constructor {
  def main(args: Array[String]): Unit = {
    val student1 = new Student()
    student1.Student()
    //�����췽��������
    //һ�㷽��������

    val student2 = new Student("alice")
    //�����췽��������
    //����������һ������
    //name:alice age: 0

    val student3 = new Student("alice",25)
    //�����췽��������
    //����������һ������
    //name:alice age: 0
    //�������췽����������
    //name:alice age: 25
  }
}

//����һ����
class Student{
  //��������
  var name:String= _
  var age:Int= _
  println("�����췽��������")

  //�����������췽��
  //����������һ
  def this(name:String){
    this()  //ֱ�ӵ�����������
    println("����������һ������")
    this.name=name
    println(s"name:$name age: $age")
  }
  //������������
  def this(name : String,age: Int) {
    this(name)
    println("�������췽����������")
    this.age= age
    println(s"name:$name age: $age")
  }

  //һ�㷽��
  def Student():Unit={
    println("һ�㷽��������")
  }
}
