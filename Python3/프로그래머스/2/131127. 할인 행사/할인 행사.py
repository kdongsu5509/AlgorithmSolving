from collections import Counter

def solution(want, number, discount):
    answer = 0
    dic = dict(zip(want, number))  # want와 number를 딕셔너리로 변환

    # 할인 정보의 길이가 10 이상인 경우에만 처리
    for i in range(len(discount) - 9):
        # 할인 정보에서 10개의 요소를 가져와서 Counter로 변환하여 딕셔너리로 만듦
        discount_counter = Counter(discount[i:i + 10])
        
        # 할인 정보와 일치하는 상품과 번호의 조합이 있는지 확인
        if dic == discount_counter: 
            answer += 1

    return answer
#진짜 개지린다.... 내 Github Upload용 긁어서 정리해놓은 내용.
"""`Counter()` 함수는 주어진 iterable에서 각 요소의 개수를 세어 딕셔너리로 반환합니다. 여기서 `discount[i:i + 10]`는 `discount` 리스트에서 인덱스 `i`부터 `i+9`까지의 요소를 잘라서 새로운 리스트를 만듭니다. 그런 다음 이 리스트를 `Counter()` 함수에 전달하여 할인 정보를 딕셔너리로 만들어줍니다.

예를 들어, `discount` 리스트에서 `i=0`일 때, `discount[0:10]`은 처음부터 10번째 요소까지의 리스트를 가져옵니다. 그리고 `Counter()` 함수에 이 리스트를 전달하여 할인 정보를 세는 것입니다.

이렇게 하면 할인 정보의 연속된 10개의 요소를 가지고 각 상품에 대한 할인을 효율적으로 판단할 수 있습니다."""