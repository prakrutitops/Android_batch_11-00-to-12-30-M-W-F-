fun main()
{
    println("Enter your choice")
    var choice= readLine()!!.toInt()

    when(choice)
    {
         1 ->
         {
             println("Selected Language is English")
         }
         2 ->
         {
             println("Selected Language is Hindi")
         }
         3 ->
         {
             println("Selected Language is Gujarati")
         }

    }
}