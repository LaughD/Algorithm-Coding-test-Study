"""
    Code written on May 29, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    09375번: 패션왕 신해빈
    link: https://www.acmicpc.net/problem/9375
"""
from sys import stdin


def main():
    for _ in range(int(stdin.readline())):
        clothing_counter = {}
        for _ in range(int(stdin.readline())):
            clothes, clothing = stdin.readline().split()
            if clothing in clothing_counter:
                clothing_counter[clothing] += 1
            else:
                clothing_counter[clothing] = 2
        num_cases = 1
        for case in clothing_counter.values():
            num_cases *= case
        print(num_cases - 1)


main()
