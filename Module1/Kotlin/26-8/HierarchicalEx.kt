open class Bank
{
    fun bank()
    {
        println("Banking")
    }
}
class Current :Bank()
{
    fun current()
    {
        println("Current detail accessed")
    }

}
class Save :Bank()
{
    fun save()
    {
        println("saving")
    }
}
fun main()
{
    var c=Current()
    var s=Save()

    c.current()
    s.save()
    c.bank()
}