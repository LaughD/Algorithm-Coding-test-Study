"""
    Code written on Mar 3, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02042번: 구간 합 구하기
    link: https://www.acmicpc.net/problem/2042
"""
from sys import stdin


def main():
    def set_tree(index, number):
        while index <= n:
            tree[index] += number
            index += index & -index

    def get_interval_sum(start, end):
        return str(get_cumulative_sum(end) - get_cumulative_sum(start - 1))

    def get_cumulative_sum(index):
        cumulative_sum = 0
        while index:
            cumulative_sum += tree[index]
            index -= index & -index
        return cumulative_sum

    n, m, k = map(int, stdin.readline().split())
    numbers = [0] * (n + 1)
    tree = [0] * (n + 1)

    for i in range(1, n + 1):
        input_number = int(stdin.readline())
        numbers[i] = input_number
        set_tree(i, input_number)

    interval_sums = []
    for i in range(m + k):
        a, b, c = map(int, stdin.readline().split())
        if a == 1:
            set_tree(b, c - numbers[b])
            numbers[b] = c
        else:
            interval_sums.append(get_interval_sum(b, c))
    print("\n".join(interval_sums))


main()
