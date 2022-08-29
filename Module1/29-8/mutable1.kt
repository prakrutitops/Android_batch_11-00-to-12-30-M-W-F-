fun main()
{
    var a1= mutableListOf<String>("a","b","c")

    a1.add("d")

    var a2= mutableListOf("d","e","f","a")

   // a1.addAll(a2)

   // a1.removeAt(1)
   // a1.removeAll(a2)

    a1.retainAll(a2)
    for( element in a1)
    {
        println(element)
    }
   /* for (element in a1)
    {*/
        println(a1)
    //}


}