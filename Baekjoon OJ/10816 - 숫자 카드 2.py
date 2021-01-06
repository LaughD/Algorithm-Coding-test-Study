"""
    Code written on Jan 6, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10816번: 숫자 카드 2
    link: https://www.acmicpc.net/problem/10816
"""
from collections import Counter
from sys import stdin


_ = stdin.readline()
counter = Counter(stdin.readline().split())
__ = stdin.readline()
print(' '.join(f"{counter[num]}" if num in counter
               else '0'
               for num in stdin.readline().split()))
