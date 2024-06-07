package stage1

fun main() {
//    show(-1)
    show(20)
}

private fun show(number: Int) {
    when(number) {
        -1 -> TODO("wrong input") // 会终止程序
        in 0..59 -> println("fail")
        in 60..100 -> println("pass")
    }
}