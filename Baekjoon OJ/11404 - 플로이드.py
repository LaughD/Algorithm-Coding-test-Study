"""
    Code written on Feb 25, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    11404번: 플로이드
    link: https://www.acmicpc.net/problem/11404
"""
from sys import stdin


def main():
    n = int(stdin.readline())
    graph = [[1e9] * (n + 1) for i in range(n + 1)]

    for i in range(1, n + 1):
        graph[i][i] = 0

    for _ in range(int(stdin.readline())):
        a, b, c = map(int, stdin.readline().split())
        if graph[a][b] > c:
            graph[a][b] = c

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                cost = graph[i][k] + graph[k][j]
                if graph[i][j] > cost:
                    graph[i][j] = cost

    print(
        "\n".join(
            ' '.join('0' if j == 1e9 else str(j) for j in graph[i][1:])
            for i in range(1, n + 1)
        )
    )


main()
