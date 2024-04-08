num = int(input())

stack = []
top = -1

while num != 0:
    stack.append(str(num % 2))
    num = num // 2
    top = top + 1

while(top != -1):
    print(stack.pop(), end="")
    top = top - 1
