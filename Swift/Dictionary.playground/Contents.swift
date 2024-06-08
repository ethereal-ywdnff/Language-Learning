import UIKit

// Dictionary也是无序的
var dic:Dictionary<Int, String> = [:]
print(dic)

var dic1 = [1:"a", 2:"b"]
print(dic1[1])
var dic2:Dictionary = [1:"a", 2:"b"]
print(dic2[1])
var dic3:Dictionary<Int, String> = [1:"a", 2:"b"]
print(dic3[1])
print(dic3[1] ?? "unknown")

dic3[1] = "b"
print(dic3)
dic3[3] = "c"
print(dic3)
//dic3.removeValue(forKey: 3)
dic3[3] = nil // another way to remove
print("21", dic3)
dic3.removeValue(forKey: 4) // 不存在的就保持原样
print(dic3)

for (k,v) in dic3 {
    print(k, v)
}

var a = dic3[4] ?? "doesn't exist"
print(a)

var dic4 = dic2.filter({$0.value != "b"})
print(dic4)
print(type(of: dic4))


print("\n")
func test(id:Int...) -> [Int] {
    print(type(of: id))
    return id
}
print(test(id:2,3))

func test(out a:String, _ b:String) { //out是外部名称，in是方法内部名称，用_可以直接写用到的值
    print(a, b)
}
test(out:"l", "kh")

var aa:String? = nil
//var aa:String? = "swift"
func test(_ param:String?) {
    guard let value = param else {
        print("getting into the guard statement")
        return
    }
    print(value)
    
//    if let value = param {
//        print(value)
//    } else {
//        print("getting into the if statement")
//    }
}
test(aa)


var b = 2
func test(_ param: inout Int) -> Int {
    param += 2
    return param
}
print(b)
print(test(&b)) // 这会改变外部的参数的值

var c = {}
print(type(of: c))
