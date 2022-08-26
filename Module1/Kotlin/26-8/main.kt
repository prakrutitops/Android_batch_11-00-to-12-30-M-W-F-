class Student
{
    var id=1
    var name=""
    var salary=12345.67
    fun detail()
    {
        println("Your id is $id")
        println("Your name is $name")
        println("Your salary is $salary")
    }
}
fun main()
{

    var s1 = Student()

    println("Enter Your id")
    var i = readLine()!!.toInt()

    println("Enter Your name")
    var n = readLine()!!.toString()

    println("Enter Your salary")
    var s = readLine()!!.toDouble()

    s1.id=i
    s1.name=n
    s1.salary=s
    s1.detail()


}