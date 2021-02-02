"""
    Code written on Feb 2, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    15686번: 치킨 배달
    link: https://www.acmicpc.net/problem/15686
"""
from itertools import combinations
from sys import stdin


size, remaining = map(int, stdin.readline().split())
city = [stdin.readline().split() for _ in range(size)]
houses = []         # coordinates of houses
chickens = []       # coordinates of chicken stores
for row in range(size):
    for col in range(size):
        if city[row][col] == '2':
            chickens.append((row, col))
        elif city[row][col] == '1':
            houses.append((row, col))

mcd = 1e9                   # mcd: min chicken distance
for selected in combinations(chickens, remaining):
    cd = 0                  # cd: chicken distance
    for hr, hc in houses:   # hr: row of house, hc: column of house
        # cr: row of chicken store, cc: column of chicken store
        cd += min(abs(hr - cr) + abs(hc - cc) for cr, cc in selected)
    mcd = min(mcd, cd)
print(mcd)
