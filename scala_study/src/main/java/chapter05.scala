class chapter05 {
  def main(args: Array[String]): Unit = {
    val fun = (name:String)=>{println(name)}
    def f(func:String=>Unit):Unit={
      func("Heria")
    }
    f(fun)
    f((name)=>{
      println(name)
    })
  }

}
