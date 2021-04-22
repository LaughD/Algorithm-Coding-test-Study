"""
    Code written on Apr 22, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18512번: 점프 점프
    link: https://www.acmicpc.net/problem/18512
"""


def main():
    x, y, p1, p2 = map(int, input().split())
    while p1 != p2 and p1 < 10100:
        if p1 < p2:
            p1 += x
        else:
            p2 += y
    print(p1 if p1 < 10100 else -1)


main()
