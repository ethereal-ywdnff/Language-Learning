package com

fun main() {
    /*var unsafe: String? = null - 这一行声明了一个可空的字符串变量 unsafe，
    并将其初始化为 null，表示它当前不包含有效的字符串值。

    println(unsafe?.length ?: 0) - 这行代码使用了安全调用操作符 ?.。它尝试获取
    unsafe 的长度属性，即字符串的字符数。由于 unsafe 可能为 null，所以如果 unsafe
    是 null，它不会引发空指针异常，而是返回 null。如果 unsafe 不为 null，它返回字符串
    的长度。如果结果是 null，则 ?: 操作符用于提供一个备用值，这里是 0。因此，第一个
    println 打印出 0，因为 unsafe 是 null。

    unsafe = "Hello" - 这一行将 unsafe 变量的值设置为字符串 "Hello"。

    println(unsafe?.length ?: 0) - 这是第二次使用相同的安全调用操作符和备用值。现在
    unsafe 包含 "Hello"，因此 unsafe?.length 返回字符串 "Hello" 的长度，这是 5。
    因此，第二个 println 打印出 5，因为 unsafe 包含一个非空字符串。*/

    var unsafe: String? = null
    println(unsafe?.length ?: 0) // 0
    println(unsafe?.length) // null
//    println(unsafe.length) // 会报错必须是unsafe?
    unsafe = "Hello"
    println(unsafe?.length ?: 0) // 5
}