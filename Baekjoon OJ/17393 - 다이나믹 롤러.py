"""
    Code written on Jan 19, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17393번: 다이나믹 롤러
    link: https://www.acmicpc.net/problem/17393
"""
from bisect import bisect_right
from sys import stdin


_ = stdin.readline()
inks = list(map(int, stdin.readline().split()))
viscosity = list(map(int, stdin.readline().split()))

storage = {}
paintable = []
for th, ink in enumerate(inks, 1):
    if ink not in storage:
        storage[ink] = bisect_right(viscosity, ink)
    if storage[ink] <= th:
        paintable.append('0')
    else:
        paintable.append(str(storage[ink] - th))
print(" ".join(paintable))
