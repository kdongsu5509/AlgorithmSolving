x, y, w, h = map(int, input().split())


li = [h-y, x, w-x, y] #순서대로 윗변, 좌변, 우변, 밑변까지의 거리임.

print(min(li))