"""
    Code written on May 27, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    04779번: 칸토어 집합
    link: https://www.acmicpc.net/problem/4779
"""
from sys import stdin


def main():
    dp = ['-']
    for _ in range(12):
        head = dp[-1]
        dp.append(head + ' ' * len(head) + head)
    print("\n".join(dp[n] for n in map(int, stdin.read().splitlines())))


main()
