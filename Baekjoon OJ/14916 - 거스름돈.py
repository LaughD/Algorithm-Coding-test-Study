"""
    Code written on May 13, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    14916번: 거스름돈
    link: https://www.acmicpc.net/problem/14916
"""


def main():
    price = int(input())
    dp = [0, 0, 1, 0, 2, 1] + [0] * (price >= 5) * (price - 5)
    for money in range(6, 1 + price):
        if dp[money - 5]:
            dp[money] = dp[money - 5] + 1
        elif dp[money - 2]:
            dp[money] = dp[money - 2] + 1
    print(dp[price] if dp[price] else -1)


main()
