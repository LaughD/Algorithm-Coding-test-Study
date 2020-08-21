'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    02798번: 블랙잭
    link: https://www.acmicpc.net/problem/2798
'''
from sys import stdin


_, m = map(int, stdin.readline().split())
cards = sorted(list(map(int, stdin.readline().split())), reverse=True)

sum_set = set()
for a in range(len(cards)-2):
    for b in range(a+1, len(cards)-1):
        for c in range(b+1, len(cards)):
            total = cards[a] + cards[b] + cards[c]
            if total <= m:
                sum_set.add(total)
                break
print(max(sum_set))
