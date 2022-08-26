class ConstructorEx(var id:Int,var name:String)
{
  fun display()
  {
      println("Your id is $id")
      println("Your name is $name")
  }
}

fun main()
{
    var c1=ConstructorEx(101,"a")
    c1.display()

}