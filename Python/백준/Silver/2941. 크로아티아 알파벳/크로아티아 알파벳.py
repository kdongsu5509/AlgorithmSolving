string = input()

li = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

for c in li:
    string = string.replace(c, '0')
    # print(string)

print(len(string))