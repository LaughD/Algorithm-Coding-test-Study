"""
    Code written on Jan 2, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01436번: 영화감독 숌
    link: https://www.acmicpc.net/problem/1436
"""
from sys import stdin


rest_series = int(stdin.readline())
doomsday_num = 665
while rest_series:
    doomsday_num += 1
    if "666" in str(doomsday_num):
        rest_series -= 1

print(doomsday_num)
