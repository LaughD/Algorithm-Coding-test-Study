"""
    Code written on Feb 18, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18353번: 병사 배치하기
    link: https://www.acmicpc.net/problem/18353
"""
from bisect import bisect_left


n = int(input())
soldiers = list(map(int, input().split()))

lis = [soldiers.pop()]
soldiers.reverse()
for soldier in soldiers:
    if lis[-1] < soldier:
        lis.append(soldier)
    else:
        lis[bisect_left(lis, soldier)] = soldier
print(n - len(lis))
