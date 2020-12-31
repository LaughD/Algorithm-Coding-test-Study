"""
    Code written on Dec 31, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    11399번: ATM
    link: https://www.acmicpc.net/problem/11399
"""
from sys import stdin


people = int(stdin.readline())
times = [0] * 1001
sum_time = 0
max_time = 1

for time in map(int, stdin.readline().split()):
    if max_time < time:
        max_time = time
    times[time] += 1

for time in range(1, max_time+1):
    while times[time]:
        sum_time += time * people
        people -= 1
        times[time] -= 1

print(sum_time)
