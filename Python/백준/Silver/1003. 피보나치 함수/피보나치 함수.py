t = int(input())

user_in = []
for time in range(t):
    temp = int(input())
    user_in.append(temp)

#finish to getting nums.
s = max(user_in)

## let's set a dynamic programming array.
# i set the dp array size is bigger than 40. Because to aovid IndexError of this code.
dp = [[0,0] for _ in range(45)]
dp[2][0] = 1
dp[2][1] = 1
dp[3][0] = 1
dp[3][1] = 2
# for i in range(s):
for i in range(4,s + 1):
    dp[i][0] = dp[i-1][0] + dp[i-2][0]
    dp[i][1] = dp[i-1][1] + dp[i-2][1]

for x in user_in:
    if x == 0:
        print("1 0")
    elif x == 1:
        print("0 1")
    else:
        print(dp[x][0], dp[x][1])
