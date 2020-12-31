"""
    Code written on Dec 31, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    10989번: 수 정렬하기 3
    link: https://www.acmicpc.net/problem/10989
"""
# 2nd Solution: Reduced number of repetitions(print)
from sys import stdin


count = int(stdin.readline())
counter = [0] * 10001

for _ in range(count):
    counter[int(stdin.readline())] += 1

for num in range(1, 10001):
    if counter[num]:
        count -= counter[num]
        print(f"{num}\n" * counter[num], end='')
    if not count:
        break


# 1st Solution
"""
from sys import stdin


count = int(stdin.readline())
counter = [0] * 10001

for _ in range(count):
    counter[int(stdin.readline())] += 1

for num in range(1, 10001):
    while counter[num]:
        print(num)
        counter[num] -= 1
        count -= 1
    if not count:
        break
"""
