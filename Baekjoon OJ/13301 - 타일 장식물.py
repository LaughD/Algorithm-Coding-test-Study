"""
    Code written on May 25, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    13301번: 타일 장식물
    link: https://www.acmicpc.net/problem/13301
"""


def main():
    n = int(input())
    rounds = [0, 4, 6]
    rounds.extend((rounds[i] + rounds[i - 1] for i in range(2, n)))
    print(rounds[n])


main()
