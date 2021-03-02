"""
    Code written on Mar 2, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    13458번: 시험 감독
    link: https://www.acmicpc.net/problem/13458
"""
from sys import stdin


def main():
    n = int(stdin.readline())
    takers = map(int, stdin.readline().split())
    b, c = map(int, stdin.readline().split())
    print(n + sum((taker - b - 1) // c + 1 for taker in takers if taker > b))


main()
