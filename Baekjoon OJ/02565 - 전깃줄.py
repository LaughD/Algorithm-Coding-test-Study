"""
    Code written on May 22, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02565번: 전깃줄
    link: https://www.acmicpc.net/problem/2565
"""
from bisect import bisect_left
from sys import stdin


def main():
    nums = int(stdin.readline())
    connections = [tuple(map(int, stdin.readline().split())) for _ in range(nums)]
    connections.sort()
    
    dp = [connections[0][1]]
    for _, location in connections[1:]:
        if location > dp[-1]:
            dp.append(location)
        else:
            dp[bisect_left(dp, location)] = location
    print(nums - len(dp))


main()
