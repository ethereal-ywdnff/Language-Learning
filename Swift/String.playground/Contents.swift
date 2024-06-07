import UIKit

var greeting = "Hello, w"

print(greeting.count) // 逗号，空格都算一位

print(greeting[greeting.startIndex]) // the first one
print(greeting[greeting.index(before: greeting.endIndex)]) // the last one

print(greeting[greeting.index(greeting.startIndex, offsetBy: 4)]) // the 5th, i.e., offset 4 positions from the start position

var a = greeting.index(greeting.startIndex, offsetBy: 2)
var b = greeting.index(greeting.startIndex, offsetBy: 7)
print(greeting[a...b]) // from `a` to `b`
print(greeting[a..<b])

var c = greeting.firstIndex(of: "A") ?? a
print(greeting[greeting.startIndex...c])

print(greeting.prefix(5)) // print a substring of length 5

var d = greeting.index(greeting.endIndex, offsetBy: -3) // third from the bottom
print(greeting[d])
print(greeting[d...greeting.index(before: greeting.endIndex)])


print(greeting.contains("H"))
print(greeting.contains("elli"))
print(greeting.contains(where: String.contains("elli"))) // 有一个在greeting里就是true

print(greeting.hasPrefix("H"))
print(greeting.hasSuffix("a"))

greeting.append("orld")
print(greeting)

greeting.insert(contentsOf: " !!", at: greeting.index(greeting.startIndex, offsetBy: 5)) // insert at 5th

var i1 = greeting.index(greeting.startIndex, offsetBy: 5)
var i2 = greeting.index(greeting.startIndex, offsetBy: 7)
let range = i1...i2
greeting.replaceSubrange(range, with: "")


var str = "abccc"
str.remove(at: str.index(str.startIndex, offsetBy: 2)) // remove the 3rd
print(str)

var r1 = str.index(str.startIndex, offsetBy: 2)
var r2 = str.index(str.startIndex, offsetBy: 3)
var r3 = r1...r2
str.removeSubrange(r3)

for item in str {
    print(item)
}
for index in 0..<str.count {
    print(str[str.index(str.startIndex, offsetBy: index)])
}

var dy = 
"""
    hello
        swift
            world
"""

print(dy)

print(#""he"l'lo"""#)
