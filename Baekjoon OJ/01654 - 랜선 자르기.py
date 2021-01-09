"""
    Code written on Jan 9, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01654번: 랜선 자르기
    link: https://www.acmicpc.net/problem/1654
"""
from sys import stdin


k, n = map(int, stdin.readline().split())
lans = [int(stdin.readline()) for _ in range(k)]

min_len = 1
max_len = max(lans)

while min_len <= max_len:
    mid_len = (min_len + max_len) // 2

    production = sum(((lan // mid_len) for lan in lans))
    if production >= n:
        min_len = mid_len + 1
    else:
        max_len = mid_len - 1

print(max_len)
