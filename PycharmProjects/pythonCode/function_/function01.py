def my_len(data):
    count = 0
    for i in data:
        count += 1
    print(count)


my_len("1234")
print()


def add(a, b):
    """

    :param a:
    :param b:
    :return:
    """
    result = a + b
    return result

print(add(2, 5))


num = 100
def m1():
    num = 200
    print(num)
m1()
print(num)  # 依然是100

def m2():
    global num  # 全局变量，修改外部的变量
    num = 200
    print(num)
m2()
print(num)  # 200
