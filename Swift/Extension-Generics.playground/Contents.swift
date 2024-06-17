import UIKit

class A {
    var greeting = "hello"
    
}

extension A {
//    var name = "swift" // Extensions must not contain stored properties
    var name:String {return "swift"}
    
    func toString() {
        print(self.greeting + "world")
    }
}

var a = A()
print(a.name)
a.toString()
print("-------------------")


func swapValues<T>(_ a: inout T, _ b: inout T) {
    let temporaryA = a
    a = b
    b = temporaryA
}

var first = "first"
var second = "second"
swapValues(&first, &second)
print("first is now \(first), second is now \(second)")
print("-------------------")


// self. is not necessary as the parameter can be distinguished
/*struct*/ class Stack<Element> {
    var items = [Element]()
    
    /*mutating*/ func push(_ item: Element) {
        items.append(item)
    }
    
    /*mutating*/ func pop() -> Element {
        return items.removeLast()
    }
}

var stackOfStrings = Stack<String>()
stackOfStrings.push("hello ")
stackOfStrings.push("world")
print(stackOfStrings.pop())
print("-------------------")

// Generics in protocol
protocol Test {
    associatedtype S
    
    func play(_ param:S)
}

class Student:Test {
    func play(_ param:String) {
        print(param)
    }
}

var s = Student()
s.play(/*game:*/ "lllllkkk")
