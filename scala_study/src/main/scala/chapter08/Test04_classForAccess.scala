package chapter08
object Test04_classForAccess {

}

//����һ������
class Person{
  private var idCard:String = "3525"
  protected var name:String="Alice"
  var sex:String="female"
  private[chapter08] var age : Int = 18
  def printInfo(): Unit = {
    println(s"Person: $idCard $name $sex $age")
  }
}


