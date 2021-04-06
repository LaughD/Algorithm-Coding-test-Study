"""
    Code written on Apr 6, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02164번: 카드2
    link: https://www.acmicpc.net/problem/2164
"""


def main():
    cards = [number for number in range(1, 1 + int(input()))]
    top = 1
    for _ in range(len(cards) - 2):
        cards.append(cards[top])
        top += 2
    print(cards.pop())


main()
