class OverloadingEx
{

    fun add(a:Int,b:Int):Int
    {
        return a+b
    }
    fun add(a:Int,b:Int,c:Int):Int
    {
        return  a*b*c
    }

}

fun main()
{
    var o1 =OverloadingEx()
    println(o1.add(5,6))
    println(o1.add(5,6,7))

}