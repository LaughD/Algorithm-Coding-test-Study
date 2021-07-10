"""
    Python Version: Python 3.9.4
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    15663 - N과 M (9), https://www.acmicpc.net/problem/15663
"""
from sys import stdin


def main():
    def permutations(turn):
        if turn == permutation_length:
            print(*permutation)
            return
        last_number = 0
        for index in range(num_numbers):
            if selected[index] or last_number == numbers[index]:
                continue
            selected[index] = True
            permutation.append(last_number := numbers[index])
            permutations(turn + 1)
            selected[index] = False
            permutation.pop()

    num_numbers, permutation_length = map(int, stdin.readline().split())
    numbers = sorted(map(int, stdin.readline().split()))
    selected = [False] * num_numbers
    permutation = []
    permutations(0)


main()
