"""
    Code written on Jan 15, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10830번: 행렬 제곱
    link: https://www.acmicpc.net/problem/10830
"""
from sys import stdin


def mul_matrix(matrix_a, matrix_b):
    global size
    new_matrix = [[0] * size for _ in range(size)]
    for i in range(size):
        for j in range(size):
            for k in range(size):
                new_matrix[i][j] += matrix_a[i][k] * matrix_b[k][j]
            new_matrix[i][j] %= 1000
    return new_matrix


size, power = map(int, stdin.readline().split())
result = [[1 if r == c else 0 for c in range(size)] for r in range(size)]
matrix = [list(map(int, stdin.readline().split())) for _ in range(size)]
while power:
    if power % 2:
        result = mul_matrix(result, matrix)
    matrix = mul_matrix(matrix, matrix)
    power //= 2

for row in result:
    print(*row)
