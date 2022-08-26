interface A1
{
    fun a1()
}
interface  B1
{
    fun b1()
}
class MutipleEx :A1,B1
{
    override fun a1()
    {
        println("A Detail Accessed")
    }

    override fun b1()
    {
        println("B Detail Accessed")
    }

}

fun main()
{
    var m1=MutipleEx()
    m1.a1()
    m1.b1()
}