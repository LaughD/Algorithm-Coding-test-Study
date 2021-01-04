"""
    Code written on Jan 4, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01676번: 팩토리얼 0의 개수
    link: https://www.acmicpc.net/problem/1676
"""
# 2nd Solution
from sys import stdin


num = int(stdin.readline())

square_num = 5
count = 0
while num >= square_num:
    count += num//square_num
    square_num *= 5

print(count)


# 1st Solution: It is possible because the input(N) range is 0 <= N <= 500
"""
from sys import stdin


num = int(stdin.readline())
print(num//5 + num//25 + num//125)
"""
