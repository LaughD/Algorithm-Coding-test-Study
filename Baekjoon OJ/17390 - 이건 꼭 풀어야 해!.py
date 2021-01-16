"""
    Code written on Jan 16, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17390번: 이건 꼭 풀어야 해!
    link: https://www.acmicpc.net/problem/17390
"""
from sys import stdin


size, repetitions = map(int, stdin.readline().split())
sequence = sorted(map(int, stdin.readline().split()))

cumulative_sums = [0]
cumulative_sum = 0
for num in sequence:
    cumulative_sum += num
    cumulative_sums.append(cumulative_sum)
for _ in range(repetitions):
    left, right = map(int, stdin.readline().split())
    print(cumulative_sums[right]-cumulative_sums[left-1])
