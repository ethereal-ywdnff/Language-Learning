package stage2

/*
29
 */
fun main() {
    val method01 = { a:Double, b:Float, c:Int ->
        "a: $a\tb: $b\tc: $c"
    }
    println(method01(452.3, 345.3f, 99))


    val method02 = { a:Double, b:Float, c:Int ->
        "sum: ${a+b+c}"
    }
    println(method02(1.20, 2.3f, 3))


    val weekResult = { number : Int ->
        when(number) {
            1 -> "Monday"
            2 -> "Tuesday"
            else -> -1
        }
    } // weekResult function: (Int) -> Any
    println(weekResult(2))
}