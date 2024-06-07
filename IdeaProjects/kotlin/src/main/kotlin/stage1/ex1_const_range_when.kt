package stage1

const val PI = 3.14 // 编译时常量 只能定义在function外

fun main() {
    val info = "aaa"
    // const val PI = 3.14
    range1()
    when1()

    val garden = "garden"
    val time = 6

    println("today go to the $garden for $time hours")

    val isLogin = true
    println("server response result: ${if (isLogin) "congratulation" else "cannot login"}")

}

fun range1() {
    var a = 100
    if (a in 0..100) {
        println(a)
    }
}

fun when1() {
    val week = 4

    val info = when(week) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        else -> "wrong info"
    }

    println(info)
}

