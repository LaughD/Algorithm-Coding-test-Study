"""
    Code written on Jan 9, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02110번: 공유기 설치
    link: https://www.acmicpc.net/problem/2110
"""
from sys import stdin


num_houses, supply = map(int, stdin.readline().split())
houses = [int(stdin.readline()) for _ in range(num_houses)]
houses.sort()

min_distance = 1
max_distance = (houses[-1]-houses[0]) // (supply-1)

while min_distance <= max_distance:
    mid_distance = (min_distance + max_distance) // 2
    demand = 1
    base_point = houses[0]

    for house in houses[1:]:
        if house - base_point >= mid_distance:
            demand += 1
            base_point = house
        if demand == supply:
            min_distance = mid_distance + 1
            break
    else:
        max_distance = mid_distance - 1

print(max_distance)
