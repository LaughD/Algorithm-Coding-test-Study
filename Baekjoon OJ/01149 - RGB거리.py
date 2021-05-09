"""
    Code written on May 9, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01149번: RGB거리
    link: https://www.acmicpc.net/problem/1149
"""
from sys import stdin


def main():
    num_houses = int(stdin.readline())
    dp = [list(map(int, stdin.readline().split()))]
    for index in range(1, num_houses):
        dp.append(list(map(int, stdin.readline().split())))
        dp[index][0] += min(dp[index - 1][1], dp[index - 1][2])
        dp[index][1] += min(dp[index - 1][0], dp[index - 1][2])
        dp[index][2] += min(dp[index - 1][0], dp[index - 1][1])
    print(min(dp[-1]))


main()
