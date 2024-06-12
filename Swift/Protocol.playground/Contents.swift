import UIKit

// 协议里的东西，不管是变量还是方法都要在类里面提及

protocol p1 {
    var value1:String{get}
    func pv1() -> String
}

protocol p2 {
    var value2:String{get set}
    func pv2()
}

class A:p1, p2 {
    var value1: String/*{return "hello "}*/ = "hello "
    var value2: String
    
    init(value: String = "swift") {
        value2 = value
    }
    
    func pv1() -> String {
        return value1 + value2
    }
    func pv2() {
        value2 = "111"
        print(value1 + value2)
    }
    
}

var a = A()
a.value1 = "222 "
print(a.value1)
print(a.value2)
print(a.pv1())
a.pv2()
print("----------------")

