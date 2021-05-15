"""
    Code written on May 15, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02740번: 행렬 곱셈
    link: https://www.acmicpc.net/problem/2740
"""
from sys import stdin


def main():
    n, m = read()
    matrix_a = [list(read()) for _ in range(n)]
    m, k = read()
    matrix_b = transpose([list(read()) for _ in range(m)])
    matrix_c = [sum(map(lambda e1, e2: e1 * e2, row_a, row_b)) 
                for row_a in matrix_a for row_b in matrix_b]
    for i in range(0, n * k, k):
        print(*matrix_c[i:i + k])


def read():
    return map(int, stdin.readline().split())


def transpose(matrix):
    return list(map(list, zip(*matrix)))


main()
