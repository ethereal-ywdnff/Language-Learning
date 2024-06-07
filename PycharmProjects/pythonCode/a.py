# 创建一个文件 demo.txt，并往里面输出hello, world
# a+: 如果文件不存在就创建，存在就在文件内容的后面继续追加
# fp=open('/Users/move/PycharmProjects/pythonCode/demo.txt', 'a+')
# print('hello, world', file=fp)
# fp.close()

# \n 换行
# \t 四个空格
# \r \r前面的会全部消失
print('hello sadaddqd  \rworld')
# \b 删掉前面一个
print('hello \bworld')
# 原字符: 不希望字符串中的转义符起作用，在字符串前加上r或者R
print(r'hello\nworld')
print(r'\\')

print("\"ds\"")
print('\'cd\'')

# 不换行
print("aa", end='')
print("aa")
