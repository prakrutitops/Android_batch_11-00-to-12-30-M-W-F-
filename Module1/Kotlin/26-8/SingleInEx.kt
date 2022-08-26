open class A
{
    fun A()
    {
        println("A Details aCCESEED")
    }
}
open class B : A()
{
    fun B()
    {
        println("B Details Accessed")
    }
}
class C:B()
{
    fun C()
    {
        println("C Details Accessed")
    }
}

    fun main()
    {
        var c=C()
        c.A()
        c.B()
        c.C()


    }

