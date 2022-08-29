class lamdaEx
{
    fun addTwoNum(a: Int , b : Int,action: (Int) ->Unit)
    {
        val sum = a+b
        action(sum)
    }
}

fun main()
{
    val my = lamdaEx()

    val myLambda : (Int) -> Unit={s : Int ->println(s)}

        my.addTwoNum(2,7,myLambda)

}