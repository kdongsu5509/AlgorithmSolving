from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0 # it define as a time.
    #let truck length is 1.
    
    waiting = deque(truck_weights)
    passing_total = deque() #2D
    passing_weight = deque() #1D
    # passing_weight.append()
    while(1):
        if len(passing_total) != 0 and passing_total[0][1] >= bridge_length:
            passing_total.popleft()
            passing_weight.popleft()
        if sum(passing_weight) <= weight:
            if len(waiting) != 0 and sum(passing_weight) + waiting[0] <= weight:
                popped = waiting.popleft()
                passing_total.append([popped, 0])
                passing_weight.append(popped)
        answer+=1
        for x in passing_total:
            x[1] += 1
        # print("passing total : ", passing_total)
        # print("passing weight : ", passing_weight)
        # print("waiting : ", waiting)
        # print("-----------------------------------")
        if not passing_total:
            break
        
    return answer