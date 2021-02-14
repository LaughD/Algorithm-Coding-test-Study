"""
    Code written on Feb 14, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01932번: 정수 삼각형
    link: https://www.acmicpc.net/problem/1932
"""
from sys import stdin


n = int(stdin.readline())
stars = [list(map(int, stdin.readline().split())) for _ in range(n)]
for i in range(1, n):
    stars[i][0] += stars[i-1][0]
    for j in range(1, i):
        stars[i][j] += max(stars[i-1][j-1], stars[i-1][j])
    stars[i][-1] += stars[i-1][-1]
print(max(stars.pop()))
