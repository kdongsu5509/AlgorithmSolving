hashMap = {}
res = []

a = input()
keys = map(int, input().split())
for k in keys:
    hashMap[k] = 1
b = input()
resKeys = map(int, input().split())
for rk in resKeys:
    # if rk in hashMap:
    #     res.append(hashMap[rk])
    # else:
    #     res.append(0)
    res.append(hashMap.get(rk, 0))

for r in res:
    print(r, end=" ")