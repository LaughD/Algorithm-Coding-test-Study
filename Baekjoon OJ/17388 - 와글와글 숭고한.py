"""
    Code written on Jan 16, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17388번: 와글와글 숭고한
    link: https://www.acmicpc.net/problem/17388
"""
from sys import stdin


scores = list(map(int, stdin.readline().split()))
print("OK" if sum(scores) >= 100
      else ("Soongsil", "Korea", "Hanyang")[scores.index(min(scores))])
