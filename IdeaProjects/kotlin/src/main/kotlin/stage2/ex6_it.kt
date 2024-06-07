package stage2

fun main() {
    fun method01(it : String) : String {
        return "$it kh"
    }

    val method02 : (String) -> String = { "$it kanghua"}

    println(method02("Liu"))
}