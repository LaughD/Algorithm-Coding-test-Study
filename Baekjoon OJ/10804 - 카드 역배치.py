"""
    Code written on May 4, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10804번: 카드 역배치
    link: https://www.acmicpc.net/problem/10804
"""
from sys import stdin


def main():
    cards = [number for number in range(1, 21)]
    for _ in range(10):
        start, end = map(int, stdin.readline().split())
        cards[start-1:end] = cards[start-1:end][::-1]
    print(*cards, sep=' ')


main()
