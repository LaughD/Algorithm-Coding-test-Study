"""
    Code written on May 23, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    11054번: 가장 긴 바이토닉 부분 수열
    link: https://www.acmicpc.net/problem/11054
"""
from bisect import bisect_left
from sys import stdin


def main():
    sequence_size = int(stdin.readline())
    sequence = list(map(int, stdin.readline().split()))
    partial_sequence_length = [0] * sequence_size

    partial_sequence = [0]
    for index in range(sequence_size):
        if sequence[index] > partial_sequence[-1]:
            partial_sequence.append(sequence[index])
            partial_sequence_length[index] += len(partial_sequence) - 1
        else:
            idx = bisect_left(partial_sequence, sequence[index])
            partial_sequence[idx] = sequence[index]
            partial_sequence_length[index] += idx

    partial_sequence = [0]
    for index in range(sequence_size - 1, -1, -1):
        if sequence[index] > partial_sequence[-1]:
            partial_sequence.append(sequence[index])
            partial_sequence_length[index] += len(partial_sequence) - 1
        else:
            idx = bisect_left(partial_sequence, sequence[index])
            partial_sequence[idx] = sequence[index]
            partial_sequence_length[index] += idx

    print(max(partial_sequence_length) - 1)


main()
