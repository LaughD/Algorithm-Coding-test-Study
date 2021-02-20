"""
    Code written on Feb 20, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 거스름돈(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12907
"""


def solution(n, money):
    MOD = 1000000007
    dp = [0] * (n + 1)
    dp[0] = 1
    for coin in money:
        for price in range(coin, n + 1):
            dp[price] = (dp[price] + dp[price - coin]) % MOD
    return dp.pop()
