"""
    Code written on Feb 6, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18405번: 경쟁적 전염
    link: https://www.acmicpc.net/problem/18405
"""
from sys import stdin


n, k = map(int, stdin.readline().split())
lab = [stdin.readline().split() for _ in range(n)]
s, x, y = map(int, stdin.readline().split())

if not s:
    print(lab[x-1][y-1])
else:
    x -= 1
    y -= 1
    virus = 1e9
    for i in range(n):
        for j in range(n):
            if lab[i][j] != '0':
                v = int(lab[i][j])
                distance = abs(i - x) + abs(j - y)
                if distance < s:
                    virus = v
                    s = distance
                elif distance == s and v < virus:
                    virus = v
    print(virus if virus != 1e9 else 0)
