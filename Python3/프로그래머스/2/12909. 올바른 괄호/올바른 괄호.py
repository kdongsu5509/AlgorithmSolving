def solution(s):
    stack = []
    answer = True
    for p in s:
        if p == '(':
            stack.append(p)
        elif p == ')' and len(stack) != 0:
            stack.pop()
        else:
            stack.append(p)
    if len(stack) != 0:
        answer = False
    print(stack)
    
    
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    # print('Hello Python')

    return answer