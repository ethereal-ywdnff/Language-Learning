money = 10000


def saving():
    global money
    money += 1000
    print(money)
    while money < 15000:
        saving()


saving()



