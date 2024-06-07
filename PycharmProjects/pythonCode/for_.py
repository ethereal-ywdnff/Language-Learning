name = "lkh"
for x in name:
    print(x)


name = "n a f af s vab h d"
i = 0
for x in name:
    if x == "a":
        i += 1
print(f"number of a: {i}")


for i in range(1, 10):
    for j in range(1, i+1):
        print(f"{i}*{j}\t", end='')
    print()
