import java.lang.ArithmeticException

class ThrowEx
{
    fun validate(age:Int)
    {
        if(age>18)
        {
            println("Eligible")
        }
        else
        {
            throw ArithmeticException("Age is not valid")
        }
    }
}
fun main()
{
    var t =ThrowEx()
    t.validate(16)
}