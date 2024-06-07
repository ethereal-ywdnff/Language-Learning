package stage1

fun main() {
    method01(18, "Tom")
    method02(20)
    method03(name = "L", age = 18)
}


private fun method01(age: Int, name: String) : Int{
    println("Your name is $name")
    println("Your age is $age")
    return 200
}

/* java version of fun method01()
private static final int method01(int age, String name) {
      String var2 = "Your name is " + name;
      System.out.println(var2);
      var2 = "Your age is " + age;
      System.out.println(var2);
      return 200;*/

private fun method02(age: Int, name: String = "Tim"){
    println("\nYour name is $name")
    println("Your age is $age")
}


private fun method03(age: Int, name: String){
    println("\nYour name is $name")
    println("Your age is $age")
}


private fun method04() : Unit{ // unit不写，默认也有，代表无参数返回
    println()
}