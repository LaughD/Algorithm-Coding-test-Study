'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    03052번: 나머지
    link: https://www.acmicpc.net/problem/3052
'''
from sys import stdin


numbers = [int(stdin.readline().strip()) for count in range(10)]
numbers = set(map(lambda d: d % 42, numbers))
print(len(numbers))