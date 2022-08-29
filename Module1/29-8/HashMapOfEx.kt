fun main()
{

    var myMap = HashMap<Int,String>()
    myMap.put(2,"Kotlin")
    myMap.put(30,"JAVA")
    myMap.put(45,"Tops")


    for(key in myMap.keys)
    {
        println("Element at key : $key = ${myMap[key]}")
    }
}