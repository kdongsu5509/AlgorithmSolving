def solution(s):
    # 함수를 완성하세요
    result = []
    for i in s:
        if not result or result[-1] != i:
            result.append(i)
    return result
