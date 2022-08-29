import java.io.FileOutputStream

fun main()
{
    var s="Welcome to Tops"
    var fout = FileOutputStream("E://abc.txt")
    fout.write(s.toByteArray())
    println("Success")

}