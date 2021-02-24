"""
    Code written on Feb 24, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18428번: 감시 피하기
    link: https://www.acmicpc.net/problem/18428
"""
from itertools import combinations
from sys import stdin


n = int(stdin.readline())
hallway = [stdin.readline().split() for _ in range(n)]

teachers = set()
floors = set()
for i in range(n):
    for j in range(n):
        if hallway[i][j] == 'T':
            teachers.add((i, j))
        elif hallway[i][j] == 'X':
            floors.add((i, j))


def check():
    for y, x in teachers:
        for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            ny = y + dy
            nx = x + dx
            while 0 <= ny < n and 0 <= nx < n:
                if hallway[ny][nx] == 'S':
                    return False
                if hallway[ny][nx] == 'W':
                    break
                ny += dy
                nx += dx
    return True


def install_walls():
    for y, x in coordinates:
        hallway[y][x] = 'W'


def uninstall_walls():
    for y, x in coordinates:
        hallway[y][x] = 'X'


for coordinates in combinations(floors, 3):
    install_walls()
    if check():
        print("YES")
        break
    uninstall_walls()
else:
    print("NO")
