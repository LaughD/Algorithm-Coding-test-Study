"""
    Code written on May 29, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10546번: 배부른 마라토너
    link: https://www.acmicpc.net/problem/10546
"""
from sys import stdin


def main():
    name_counter = {}
    for _ in range(int(stdin.readline())):
        name = stdin.readline().rstrip()
        if name in name_counter:
            name_counter[name] += 1
        else:
            name_counter[name] = 1

    while name := stdin.readline().rstrip():
        if name_counter[name] == 1:
            name_counter.pop(name)
        else:
            name_counter[name] -= 1
    print([name for name in name_counter][0])


main()
