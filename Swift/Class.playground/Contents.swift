import UIKit

class Student{
    var name = "unknown"
    var age = -1
    var score = -1.0
    var isPass = "fail"
    let school = "Sheffield"
    
    var abc = "abc"
    
    init(name: String = "", age: Int = 1, score: Double = -1.0, isPass: String = "fail") {
        self.name = name
        self.age = age
        
        checkIsPass(param:score)
    }
    
    private func checkIsPass(param score:Double){
        self.score = score
        if score >= 60 {
            self.isPass = "pass"
        } else {
            self.isPass = "fail"
        }
    }
    func getDetail() -> String {
        return "\(self.name) \t \(self.age) yesrs old \t \(self.score) \t \(self.isPass) \t school: \(self.school)"
    }
    public func getName() -> String {
        return self.name
    }
    public func getABC() -> String {
        return ""
    }
}

var student = Student()
print(student.getDetail())
print("-------------------")

var student1 = Student(name:"tom",age: 18,score: 65)
print(student1.getDetail())
print("-------------------")

var student2: Any = Student(name: "Perry", age: 118, score: 165)
//var s = student2 as? Student
//print(s?.getDetail())
//print(s!.getDetail())
if let student = student2 as? Student {
    print(student.getDetail())
} else {
    print("Conversion failed")
}
// 使用 as! 进行强制类型转换
print((student2 as! Student).getDetail())
print("-------------------")

var student3:AnyObject = Student(name:"perry",age: 118,score: 165)
print(type(of: student3))
var a:Any = 1.1
print(type(of: a))
// `AnyObject` can represent an instance of any class type. It's used for objects that are reference types, which means it's applicable to instances of classes (not structures or enumerations).
// `Any` can represent an instance of any type at all, including function types, structs, classes, enums, and optional types. It covers literally any kind of type, not limited to class types.
print("-------------------")


class Stu : Student {
    override var name: String {
        set{
            super.name = "stu: " + super.name
        }
        get{
            return super.name
        }
    }
    override init(name: String, age: Int, score: Double, isPass: String = "fail") {
        super.init(name: name, age: age, score: score)
        self.name = name
    }
    override func getABC() -> String {
        return super.abc
    }
    public override func getName() -> String {
        return "111"
    }
}

var stu:Student = Stu(name:"tom",age: 18,score: 65)
print(stu.getName())
print(stu.name)
print(stu.getDetail())
print(stu.getABC())

var t1 = Student()
var t2 = Student()
var t3 = t1
print(t1 !== t2)
print(t1 === t3)
