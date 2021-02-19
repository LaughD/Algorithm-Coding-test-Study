"""
    Code written on Feb 19, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    14501번: 퇴사
    link: https://www.acmicpc.net/problem/14501
"""
from sys import stdin


n = int(stdin.readline())
t = []
p = []
for _ in range(n):
    ti, pi = map(int, stdin.readline().split())
    t.append(ti)
    p.append(pi)

dp = [0] * (n + 1)
for i in range(n - 1, -1, -1):
    day = i + t[i]
    dp[i] = max(p[i] + dp[day], dp[i + 1]) if day <= n else dp[i + 1]
print(dp[0])
