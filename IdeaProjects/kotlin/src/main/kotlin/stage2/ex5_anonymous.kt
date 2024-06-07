package stage2

fun main() {
    val len1 = "aaaaa".count() // 计算有多少个字符
    println(len1)

    val len2 = "aaak".count() {// 计算有多少个a
        it == 'a'
    }
    println(len2)


    val method01 : () -> String
    method01 = {
        val a = 999
        "$a people"
    }
    println(method01())

    /*通常使用的function
    fun method01() : String {
        val a = 999
        return "$a people"
    }*/


    val method02 : (Int, Int, Int) -> String = { a, b, c ->
        "num1: $a, num2: $b, num3: $c"
    }
    println(method02(1, 2, 3))

    val d6 = createDice(6)
    val d100 = createDice(100)
    repeat(3) { println("${d6()} ${d100()}") }

    val d6_ = createDice1(6)
    val d100_ = createDice1(100)
    repeat(3) { println("$d6_ $d100_") }
}


fun createDice(sides: Int) : () -> Int{
    val roll = fun(): Int {
        return (1..sides).random()
    }
    return roll
}

fun createDice1(sides: Int) : Int{
    return (1..sides).random()

}