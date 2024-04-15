from collections import deque

def solution(priorities, location):
    priority = list(priorities)
    pq = deque() # save a list [문자 , 우선순위] 
    for x in range(len(priorities)):
        pq.append([x, priorities[x]])

    answer = 0
    priority.sort()
    
    while(pq):
        if pq[0][1] != priority[-1]:
            pq.append(pq.popleft())
        else:
            temp = pq.popleft()
            priority.pop()
            if temp[0] == location:
                print(priority)
                print(pq)
                answer+=1
                break
            else:
                answer += 1
    return answer