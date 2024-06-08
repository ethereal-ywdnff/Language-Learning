import UIKit

// Set中每个值都是唯一的，且是无序的（每次print出来顺序都不一样）

// empty set
var ss = Set<String>()
//var ss:Set<String> = []
print(ss)



//var set1:Set<String> = ["hello","world","swift"]
//var set1:Set = ["hello","world","swift"]
//var set1 = Set<String>(["hello","world","swift"])
var set1 = Set(["hello","world","swift"])
print(set1)
print(set1.count)

var (a,b) = set1.insert("bbbb")
print(a, b) // 若是插入一个已经存在于set中的值，则a返回false，b返回"bbbb"
var (c,d) = set1.insert("hello")
print(c, d) // 若是插入一个不存在于set中的值，则c返回true，d返回"hello"
set1.remove("world")
print(set1)

//print(!set1.isEmpty)

var set2 = Set(["swift","bbbb","aaaa"])
var set_i = set1.intersection(set2) // 返回两个set中相同的值
print(set_i)
var set_s = set1.subtracting(set2) // 对比两个set，返回前面set中与后面set中不同的值
print(set_s)
var sets = set1.symmetricDifference(set2) // 返回两个set中不同的值
print(sets)


var set3 = Set([1,2,3,4])

var set4 = set3.filter{$0 % 2==0}
print(set4)
set4 = set3.filter{
    if $0 == 2 || $0 == 3 {
        return false
    }
    return true
}
print(set4)
print(type(of: set4))

var set5 = set3.sorted()
print(set5)
set5 = set3.sorted{$0 > $1}
print(set5)
print(type(of: set5))

for i in set3 {
    print(i)
}

var set6 = Set([1,2,3])
var set7 = set6.map{$0 * 2}
print(set7)
