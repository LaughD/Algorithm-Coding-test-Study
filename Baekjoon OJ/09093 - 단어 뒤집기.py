'''
    Code written on Oct 25, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    09093번: 단어 뒤집기
    link: https://www.acmicpc.net/problem/9093
'''
from sys import stdin

N = int(stdin.readline())
for _ in range(N):
    print(' '.join(map(lambda x: x[::-1], stdin.readline().split())))
