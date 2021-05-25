"""
    Code written on May 25, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    07785번: 회사에 있는 사람
    link: https://www.acmicpc.net/problem/7785
"""
from sys import stdin


def main():
    names = set()
    for _ in range(int(stdin.readline())):
        name, commuting = stdin.readline().split()
        if commuting == "enter":
            names.add(name)
        else:
            names.remove(name)
    print("\n".join(sorted(names, reverse=True)))


main()
