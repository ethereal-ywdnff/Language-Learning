import UIKit

var a:Array<Int> = []
a.append(1)
a.append(2)
print(a)

var b = [String]()
b.append("w")
b[0] = "h"
print(b)

var c = Array(repeating: -1, count: 3) // 长度为3，值都为-1
print(c)

var d = [3, 4]
a += d
print(a)

d.insert(1, at: 0)
print("d", d)
print(d.contains(2))
d.replaceSubrange(0..<1, with: [1,2])
print("d", d)
d.remove(at: 3)
print("d", d)

var un = ["a","Bb","A","C"]
var s = un.filter { $0.count < 2 }
print(s)
var s1 = un.filter { $0 != "a" }
print(s1)
//un.sort()
//print(un)
un.sort()
print(un)
un.sort { $0 > $1 }
print(un)

//for i in un[0..<un.count] {
//    print(i)
//}
for i in un[0...] {
    print(i)
}
//for i in un {
//    print(i)
//}
for i in 2..<un.count {
    print(un[i])
}
