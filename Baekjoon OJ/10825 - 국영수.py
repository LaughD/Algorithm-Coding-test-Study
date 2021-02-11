"""
    Code written on Feb 11, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10825번: 국영수
    link: https://www.acmicpc.net/problem/10825
"""
from sys import stdin


report_cards = []
for _ in range(int(stdin.readline())):
    name, korean_score, english_score, math_score = stdin.readline().split()
    report_cards.append(
        (-int(korean_score), int(english_score), -int(math_score), name)
    )
report_cards.sort()
print("\n".join([report_card[3] for report_card in report_cards]))
