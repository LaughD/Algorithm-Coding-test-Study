"""
    Code written on May 13, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01764번: 듣보잡
    link: https://www.acmicpc.net/problem/1764
"""
from sys import stdin


def main():
    n, m = map(int, stdin.readline().split())
    people = stdin.read().splitlines()
    newcomer = list(set(people[:n]) & set(people[n:]))
    newcomer.sort()
    print(len(newcomer))
    for person in newcomer:
        print(person)


main()
