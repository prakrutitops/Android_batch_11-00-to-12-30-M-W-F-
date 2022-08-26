import com.sun.org.apache.xpath.internal.operations.Bool

class MyFirstClass
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }

}

fun MyFirstClass.isscholar(marks2: Int) :Boolean
{
    return marks2>90
}

fun main()
{
    var m =MyFirstClass()
    println("Passing status "+m.hasPassed(45))
    println("Scholarship status "+m.isscholar(45))

}