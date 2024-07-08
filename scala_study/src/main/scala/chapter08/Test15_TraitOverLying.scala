package chapter08

object Test15_TraitOverLying {
  def main(args: Array[String]): Unit = {
    var ball = new MyFootBall
    println(ball.describe())
  }
}
//������������
trait Ball{
  def describe():String = "ball"
}
//������ɫ����
trait ColorBall extends Ball{
  var color:String = "red"
  override def describe():String  = color + "-" +super.describe()
}
//������������
trait CategoryBall extends Ball{
  var category:String = "foot"
  override def describe():String  = category + "-" +super.describe()
}
class MyFootBall extends CategoryBall with ColorBall{
  override  def describe():String  ="my ball is a "+super.describe()
}