import UIKit

// 延迟初始化
class Data {
    init() {
        print("data")
    }
    public func pr() {
        print("swift")
    }
}
class Test {

    init() {
        print("test\n")
    }
    
    lazy var data = Data() // 这个先被执行的，加lazy后只有在被使用时才会初始化2

}

var test = Test()
test.data.pr()
print("----------------")


// 结构体会自动定义初始化，但类不行
struct B {
    var name:String
    var age:Int
    
//    init(name: String, age: Int) {
//        self.name = name
//        self.age = age
//    }
    func printDetail() {
        print("\(name), \(age) yesrs old")
    }
}

var b = B(name: "tom", age: 10)
b.printDetail()
// struc是值类型
var b1 = b // 后续b1的修改不影响b
b1.name = "cassie"
b.printDetail()
print("----------------")


// 类初始化需要明确变量的值。在申明变量的值后，仍能定义初始化
class C {
    var name:String = "tim"
    var age:Int = {
        var p = 3
        var af = 4
        return p + af
    }()
    
//    init(name: String, age: Int) {
//        self.name = name
//        self.age = age
//    }
    
    func printDetail() {
        print("\(name), \(age) yesrs old")
    }
    
    deinit { // 当一个类的实例不再需要时，Swift 通过自动引用计数（ARC）来管理内存的释放，类会被销毁，而 deinit 方法则会被调用
        print("C has been deleted")
    }
}
var c = C()
c.printDetail()
// class是引用类型
var c1 = c // 后续c1的修改影响c
c1.age = 10
c.printDetail()
print(c1 === c)
print("----------------")


var c2:C? = C()
var c3 = c2
print(type(of: c3))
c2 = nil
c3 = nil
