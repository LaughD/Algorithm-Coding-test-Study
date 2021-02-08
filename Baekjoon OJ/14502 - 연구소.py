"""
    Code written on Feb 8, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    14502번: 연구소
    link: https://www.acmicpc.net/problem/14502
"""
from itertools import combinations
from sys import stdin

n, m = map(int, stdin.readline().split())
lab = [stdin.readline().split() for _ in range(n)]


def get_new_safety_zone_area():
    new_safety_zone_area = len(blank_locations)
    stack = virus_locations[::]
    while stack:
        y, x = stack.pop()
        for i in range(4):
            next_location = (y + dy[i], x + dx[i])
            if next_location in blank_locations and \
                    next_location not in infected_locations:
                infected_locations.add(next_location)
                new_safety_zone_area -= 1
                stack.append(next_location)
        if new_safety_zone_area <= safety_zone_area:
            return 0
    return new_safety_zone_area


blank_locations = set()
virus_locations = []
for i in range(n):
    for j in range(m):
        if lab[i][j] == '0':
            blank_locations.add((i, j))
        elif lab[i][j] == '2':
            virus_locations.append((i, j))

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
safety_zone_area = 0
for combination in combinations(blank_locations, 3):
    infected_locations = set(virus_locations)
    for location in combination:
        blank_locations.remove(location)
    safety_zone_area = max(safety_zone_area, get_new_safety_zone_area())
    for location in combination:
        blank_locations.add(location)
print(safety_zone_area)
