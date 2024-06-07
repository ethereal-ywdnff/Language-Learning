for i in range(1, 3):
    print("1")
    for j in range(1, 4):
        print("2")
        continue  # 进入到这个for循环中到下一次循环
        print("3")
    for z in range(1, 3):
        print("5")
    print("4")
    print()

# for i in range(1, 3):
#     print("1")
#     for j in range(1, 4):
#         print("2")
#         break  # for循环直接结束
#         print("3")
#     for z in range(1, 3):
#         print("5")
#     print("4")
#     print()
