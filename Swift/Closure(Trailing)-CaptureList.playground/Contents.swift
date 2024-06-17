import UIKit

class Counter {
    var count = 0
    var aa = "aaa"
    lazy var increment/*: (Int, String) -> Void*/ = { [unowned self] value, string in
        self.count += value
        self.aa = string
        print(self.count, self.aa)
    }
    
    deinit {
        print("Counter is being deinitialized")
    }
}

var counter: Counter? = Counter()
counter?.increment(1, "bbb")  // 输出: 1 bbb
counter?.increment(2, "ccc")  // 输出: 3 ccc
counter = nil  // 输出: Counter is being deinitialized



class Person {
    var name: String
    var age: Int
    var greeting/*: (() -> Void)*/ = {}
    
    init(name: String, age: Int = 18) {
        self.name = name
        self.age = age
    }
    
    func setupGreeting() {
        // 使用 weak 捕获列表避免强引用循环
        greeting = { [weak self] in
            guard let self = self else { return }
            print("Hello, my name is \(self.name), \(age) years old")
        // 使用 unowned 捕获列表避免强引用循环
//        greeting = { [unowned self] in
//            print("Hello, my name is \(self.name), \(age) years old")
        }
    }
    
    deinit {
        print("\(name) is being deinitialized")
    }
}

var john: Person? = Person(name: "John")
john?.setupGreeting()
john?.greeting()  // 输出: Hello, my name is John
john = nil  // Person 实例被释放，输出: John is being deinitialized

class Address {
    var street: String?
    var city: String?
    var country: String?
}

class Person1 {
    var name: String
    var address: Address?
    
    init(name: String) {
        self.name = name
    }
}

let john1:Person1? = Person1(name: "John")
john1?.address = Address()
print(type(of: john1!.name))
john1?.address?.street = "123 Main St"
print(type(of: john1?.address?.street))
if let street = john1?.address?.street {
    print("John's street is \(street)")
} else {
    print("John's street is unknown")
}
// 输出: John's street is 123 Main St
// 就是定义类型时有?，在赋值时也要带? e.g., a? 包含 b?，那定义a?是 (a = ...)，定义b?是 (a?.b = ...)


// 尾随闭包 Trailing Closure
func play(param:(String) -> String) {
    var value = param("swift")
    print("value =",value)
}

play(param: {/*(data:String) -> String*/ data in
    return data + " —— ios"
})
play{ data in
    return data + " —— macOS"
}

func play1(param:() -> String) {
    let value = param()
    print("value =",/*value*/ param())
}
play1{() /*-> String*/ in
    return "hello"
}
