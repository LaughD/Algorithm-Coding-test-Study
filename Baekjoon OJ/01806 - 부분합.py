"""
    Code written on Mar 16, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01806번: 부분합
    link: https://www.acmicpc.net/problem/1806
"""
from sys import stdin


def main():
    n, s = map(int, stdin.readline().split())
    sequence = list(map(int, stdin.readline().split()))

    head = tail = subtotal = 0
    min_sequence_length = 1e9
    while head < n:
        while subtotal < s and tail < n:
            subtotal += sequence[tail]
            tail += 1
        if subtotal >= s and min_sequence_length > tail - head:
            min_sequence_length = tail - head
        subtotal -= sequence[head]
        head += 1
    print(min_sequence_length if min_sequence_length != 1e9 else 0)


main()
