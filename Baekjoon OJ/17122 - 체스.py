"""
    Code written on May 6, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17122번: 체스
    link: https://www.acmicpc.net/problem/17122
"""
from sys import stdin


def main():
    for _ in range(int(stdin.readline())):
        notation1, notation2 = stdin.readline().split()
        notation2 = int(notation2) - 1
        if (((ord(notation1[0]) - 1) % 2) == ((int(notation1[1]) - 1) % 2)) \
                ^ ((notation2 // 8 % 2) == (notation2 % 8 % 2)):
            print("NO")
        else:
            print("YES")


main()
