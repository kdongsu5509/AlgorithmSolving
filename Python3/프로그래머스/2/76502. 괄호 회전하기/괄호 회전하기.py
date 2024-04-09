def valid(s):
    stack = []
    for temp in s:
        if temp == '(' or temp == '{' or temp == '[':
            stack.append(temp)
        elif temp == ')':
            if not stack or stack.pop() != '(':
                return False
        elif temp == '}':
            if not stack or stack.pop() != '{':
                return False
        elif temp == ']':
            if not stack or stack.pop() != '[':
                return False
    return not stack

def solution(s):
    cnt = 0
    for i in range(len(s)):
        temp = s[i:] + s[:i]
        if valid(temp):
            cnt += 1
    return cnt
