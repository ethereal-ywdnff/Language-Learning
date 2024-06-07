import UIKit

var greeting = "Hello, playground"

let b = 1 // constant

var 🐱 = 2
var kitty = "🐱"
var w = 🐱

for i in 1 ... 🐱 {
    print("name", i)
    print("eman" + "\(i)")
}
print()
for index in stride(from: -1, to: 6, by: 3) { // stride: +3 at each step, i.e., 0 3 6 9
    print(index)
}
print("reverse")
for index in stride(from: -1, to: 6, by: 3).reversed() { // output reversely
    print(index)
}
for i in (1 ... 🐱).reversed() {
    print("cc", i)
}

while 🐱 > 0 {
    print("while:", 🐱)
    🐱 -= 1
}
🐱 = 2
repeat {
    print("repeat while:", 🐱)
    🐱 -= 1
} while 🐱 > 0



typealias cl = Int


var n = "wer"
print(cl(n) ?? 100) // if n could be covert to int, then n, else 100
var n1 = Double(n) ?? 22.8
print(cl(n1))

var t = Bool(-1) // it is always true if it's not 0
var f = Bool(0)
print(t)

var nu:cl? = nil
var ss:String? = "str"
print(type(of: n) == type(of: ss))
print(ss)
print(ss!)
print(ss ?? "str1") // can get the value when add !

if ss == nil {
    print("null")
} else {
    print("ss = \(ss!)")
    print("ss = " + ss!)
    print("ss =", ss!)
}

if let safeString = ss {
    print(safeString) // 安全地使用 safeDescription，只有当 ss 不为 nil 时才会执行
}



let tup = (1, "swift")
var tup1 = tup

tup1.0 = 2
print(tup, tup1)

var tup2 = (name1:1, name2:"sw", name3:true)
var tup3:(name1:Int, name2:String, name3:Bool) = (1, "sw", true)
print(tup2, "  ", tup2.2, "  ", tup2.name3)
print(tup3, "  ", tup3.2)


let (🤓, 🧟) = ("1", true)
print(🤓)
var (e1, e2) = (🤓, 🧟)
e1 = "🇨🇳"
print(e1)



