"""
    Code written on May 4, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10819번: 차이를 최대로
    link: https://www.acmicpc.net/problem/10819
"""
from itertools import permutations


def main():
    length = int(input())
    max_value = 0
    for array in permutations(map(int, input().split()), length):
        value = 0
        for index in range(1, length):
            value += abs(array[index - 1] - array[index])
        if value > max_value:
            max_value = value
    print(max_value)


main()
