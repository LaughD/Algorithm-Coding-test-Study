"""
    Code written on May 20, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    12865번: 평범한 배낭
    link: https://www.acmicpc.net/problem/12865
"""
from sys import stdin


def main():
    num_goods, limit_weight = map(int, stdin.readline().split())
    dp = [0] * (1 + limit_weight)
    for _ in range(num_goods):
        weight, value = map(int, stdin.readline().split())
        for liftable in range(limit_weight, weight - 1, -1):
            value_sum = dp[liftable - weight] + value
            if dp[liftable] < value_sum:
                dp[liftable] = value_sum
    print(dp.pop())


main()
