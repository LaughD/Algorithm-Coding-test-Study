"""
    Code written on Jan 3, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02884번: 알람 시계
    link: https://www.acmicpc.net/problem/2884
"""
from sys import stdin


hour, minute = map(int, stdin.readline().split())
if minute < 45:
    print(f"{(hour+23) % 24} {minute+15}")
else:
    print(f"{hour} {minute-45}")
