"""
    Code written on Dec 31, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    15651번: N과 M (3)
    link: https://www.acmicpc.net/problem/15651
"""
# 2nd Solution: Improved efficiency
# I learned that the iteration of print() is not good
from itertools import product
from sys import stdin


n, r = map(int, stdin.readline().split())
cases = product(map(str, range(1, n+1)), repeat=r)

print('\n'.join(map(' '.join, cases)))


# 1st Solution
"""
from itertools import product
from sys import stdin


n, r = map(int, stdin.readline().split())

for case in product(tuple(range(1, n+1)), repeat=r):
    print(*case)
"""
