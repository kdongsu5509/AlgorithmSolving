def solution(s):
    arr = []
    arr = map(str, s.split(' '))
    
    stack = []
    for x in arr:
        if x == 'Z':
            stack.pop()
        else:
            stack.append(int(x))
    answer = sum(stack)
    return answer