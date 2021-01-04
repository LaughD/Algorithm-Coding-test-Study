"""
    Code written on Jan 4, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    11051번: 이항 계수 2
    link: https://www.acmicpc.net/problem/11051
"""
# 2nd Solution: Combination formula(Better results)
from sys import stdin


n, k = map(int, stdin.readline().split())

if not k or n == k:
    print(1)
else:
    k = min(k, n-k)
    r = n
    for i in range(1, k):
        r -= 1
        n *= r
        k *= i
    print(n//k % 10007)


# 1st Solution: Pascal's triangle
"""
from sys import stdin


n, k = map(int, stdin.readline().split())
k = min(k, n-k)

bin_coef = [[1]*(k+1) for _ in range(n+1)]
for i in range(2, n+1):
    for j in range(k+1):
        if j and i != j:
            bin_coef[i][j] = (bin_coef[i-1][j] + bin_coef[i-1][j-1]) % 10007

print(bin_coef[n][k])
"""
