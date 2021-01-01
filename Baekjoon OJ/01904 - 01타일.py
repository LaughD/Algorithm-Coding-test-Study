"""
    Code written on Jan 1, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01904번: 01타일
    link: https://www.acmicpc.net/problem/status/1904
"""
from sys import stdin


prev = 0
this = 1
for _ in range(int(stdin.readline())):
    prev, this = this, (prev+this) % 15746

print(this)
