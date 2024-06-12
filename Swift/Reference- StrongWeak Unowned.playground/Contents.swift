import UIKit

// 强引用 strong reference
class Person {
    let name: String
    var apartment: Apartment?

    init(name: String) {
        self.name = name
    }

    deinit {
        print("strong \(name) is being deinitialized")
    }
}

class Apartment {
    let unit: String
    var tenant: Person?

    init(unit: String) {
        self.unit = unit
    }

    deinit {
        print("strong Apartment \(unit) is being deinitialized")
    }
}

var john: Person?
var unit4A: Apartment?

john = Person(name: "John Appleseed")
unit4A = Apartment(unit: "4A")

john!.apartment = unit4A
unit4A!.tenant = john

// 销毁john里的apartment和unit4A里的tenant
// 这里需要把其中所有引用都明确销毁
john!.apartment = nil
unit4A!.tenant = nil

// 销毁john和unit4A
john = nil
unit4A = nil

// 弱引用是当所引用的对象被释放时，弱引用自动变为 nil，不用手动销毁john里的apartment和unit4A里的tenant
print("--------------------------------------------------------------------------------------")


// 弱引用 weak reference
class Person1 {
    let name: String
    var apartment: Apartment1?

    init(name: String) {
        self.name = name
    }

    deinit {
        print("weak \(name) is being deinitialized")
    }
}

class Apartment1 {
    let unit: String
    weak var tenant: Person1? // 使用 weak 关键字来定义弱引用

    init(unit: String) {
        self.unit = unit
    }

    deinit {
        print("weak Apartment \(unit) is being deinitialized")
    }
}

var john1: Person1?
var unit4A1: Apartment1?

john1 = Person1(name: "John1 Appleseed")
unit4A1 = Apartment1(unit: "4A")

john1!.apartment = unit4A1
unit4A1!.tenant = john1

john1 = nil
unit4A1 = nil
// 由于弱引用的使用，Person 和 Apartment 实例都可以被正常释放

// 一个实例一旦没有任何强引用指向它，它就会被销毁
// 在这个例子中Apartment1实例的销毁是因为当 Person1 实例被销毁后，Apartment1 实例的唯一可能的强引用——即通过 Person1 实例的 apartment 属性持有的那个——也就不复存在了。而如果john1 = nil没被执行，也就是说Person1 实例没被销毁，那Apartment1 实例也不会被销毁


print("--------------------------------------------------------------------------------------")

// 无主引用 unowned reference
class Customer {
    let name: String
    var card: CreditCard?
    
    init(name: String) {
        self.name = name
    }
    
    deinit {
        print("unowned \(name) is being deinitialized")
    }
}

class CreditCard {
    let number: UInt64
    unowned let customer: Customer
    
    init(number: UInt64, customer: Customer) {
        self.number = number
        self.customer = customer
    }
    
    deinit {
        print("unowned Card #\(number) is being deinitialized")
    }
}

var tom: Customer?
tom = Customer(name: "Tom Appleseed")
tom!.card = CreditCard(number: 1234567890123456, customer: tom!)

// 当tom被置为nil时，由于没有其他强引用指向CreditCard和Customer，两个对象都会被释放。
tom = nil
