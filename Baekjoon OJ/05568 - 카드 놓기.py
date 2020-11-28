'''
    Code written on Nov 28, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    05568번: 카드 놓기
    link: https://www.acmicpc.net/problem/5568
'''
from itertools import permutations
from sys import stdin

_, K, *cards = map(int, stdin.readlines())
cards = map(str, cards)
print(len({"".join(case) for case in permutations(cards, K)}))
