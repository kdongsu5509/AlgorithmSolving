def solution(today, terms, privacies):
    deprecated = []
    year = int(today[0:4])
    month = int(today[5:7])
    day = int(today[8:])
    for i in range(len(privacies)):
        contract = privacies[i]
        for x in terms:
            if contract[-1] in x[0]:
                # print(contract[-1])
                year2 = int(contract[0:4])
                month2 = int(contract[5:7])
                day2 = int(contract[8:11])
                some = (((year - year2) * (28 * 12) + (month - month2) * 28 + (day -  day2)))
                split1, split2 = x.split()
                print(some, int(split2)*28)
                if (some >= int(split2)*28):
                    deprecated.append(i + 1)
    answer = deprecated
    return answer
