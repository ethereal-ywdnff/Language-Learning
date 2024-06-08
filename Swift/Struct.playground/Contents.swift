import UIKit

struct Student {
    var name = "tom"
    var age = 18
    var score = 23.45
    var isPass = false
    
    init(name: String = "tom", age: Int = 18, score: Double = 23.45, isPass: Bool = false) {
        self.name = name
        self.age = age
        self.score = score
        if self.score >= 60 {
            self.isPass = true
        } else {
            self.isPass = false
        }
        
    }
    
    func getName() -> String {
        return self.name
    }

    mutating func setScore(score:Double) {
        self.score = score
        if self.score >= 60 {
            self.isPass = true
        } else {
            self.isPass = false
        }
    }
}

var a = Student()
print("name:", a.getName())
print("score:", a.score, a.isPass)
a.score = 60
print("score:", a.score, a.isPass)
a.setScore(score: 60)
print("score:", a.score, a.isPass)



struct Age {
    var age = 10
}

var a1 = Age()
print("a1:", a1.age)

var a2 = a1 // 值传递，而不是传引用
a2.age = 100
print("a1: \(a1.age), a2: \(a2.age)")


struct Person {
    private var value = ""
    var name:String {
        set(name) {
            value = value + name + " "
            print("set",name)
        }
        get {
//            print("get ")
            return "name: " + value
        }
    }
    
    var age:Int = 18 {
//        willSet(new) {
//            print("latest value:",new)
//        }
//        didSet(old) {
//            print("previous value:",old)
//        }
        willSet {
            print("latest value:",newValue)
        }
        didSet {
            print("previous value:",oldValue)
        }
    }
    
    var chapters: [String] = ["第一章: 开始", "第二章: 进行", "第三章: 结束"]

    // 使用subscript定义下标脚本
    subscript(index: Int) -> String {
        get {
            // 确保索引在合理范围内
            if index >= 0 && index < chapters.count {
                return chapters[index]
            } else {
                return "索引超出范围"
            }
        }
        set {
            // 仅当索引在范围内时替换值
            if index >= 0 && index < chapters.count {
                chapters[index] = chapters[index] + " " + newValue
            } else {
                print("no such index(\(index)), so \(newValue) is been inserted to the chapters")
                chapters.append(newValue)
            }
        }
    }
}

var person = Person()
person.name = "tim"
print(person.name)
person.name = "tom"
print(person.name)
print("-------------------")
print("age",person.age)
person.age = 20
print("age",person.age)
print("-------------------")
person[0] = "新的开始"
print(person.chapters)
person[5] = "🤡"
print(person.chapters)
