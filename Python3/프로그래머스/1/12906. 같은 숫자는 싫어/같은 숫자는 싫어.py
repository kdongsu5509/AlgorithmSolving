def solution(arr):
    answer = []
    stack = []
    for element in arr:
        if not stack or stack[-1] != element:
            answer.append(element)
            stack.append(element)
        else:
            stack.append(element)
    # print('Hello Python')
    return answer