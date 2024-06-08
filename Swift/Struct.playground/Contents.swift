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
