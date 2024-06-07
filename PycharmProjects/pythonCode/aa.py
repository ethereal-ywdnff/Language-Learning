# 取整
print("11//2 = ", 11 // 2)
# 平方
print("2**2 = ", 2 ** 2)
print("hello" + "world")

# % 表示占位
# s 表示变量变成字符串放入的位置
name = "hello"
message = "hey %s" % name
print(message)

a = 10
b = 20
message = "a = %s, b = %s" % (a, b)
print(message)

# %s 字符串 %d 整数 %f 浮点数
name = "lkh"
year = 2002
score = 69.78
message = "name = %s, year = %d, score = %f" % (name, year, score)
print(message)

# m 控制宽度，要求是数字（很少使用），设置的宽度小于数字自身，不生效
# .n 控制小数点精度，要求是数字，会进行小数的四舍五入
num1 = 11
num2 = 11.5692
print("num1 = %5d" % num1)  # 五味，因为11只有两位，所以前面会有三个空格
print("num1 = %1d" % num1)
print("num2 = %7.2f" % num2)  # 七位，包括小数点和小数，所以前面有两个空格
print("num2 = %.2f" % num2)  # 会四舍五入

# f"内容{变量}内容"  原本什么样输出就会是什么样
name = "lll"
year = 2002
score = 69.783131
print(f"name = {name}, year = {year}, score = {score}")






