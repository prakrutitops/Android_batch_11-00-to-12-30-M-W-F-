open class Bank2
{
 open fun rate():Int
 {
    return  0
 }
}
class Sbi :Bank2()
{
    override fun rate():Int
    {
        return 7
    }
}
class Icici :Bank2()
{
    override fun rate():Int
    {
        return 8
    }
}
class Axis :Bank2()
{
    override fun rate():Int
    {
        return 9
    }
}


fun main()
{
    var b=Bank2()

    b=Sbi()
    println(b.rate())
    b=Icici()
    println(b.rate())
    b=Axis()
    println(b.rate())

}