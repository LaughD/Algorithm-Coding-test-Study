"""
    Code written on Apr 27, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01937번: 욕심쟁이 판다
    link: https://www.acmicpc.net/problem/1937
"""
from sys import setrecursionlimit, stdin
setrecursionlimit(300_000)


def main():
    n = int(stdin.readline())
    forest = [list(map(int, stdin.readline().split())) for _ in range(n)]
    print(find_max_survival_days(n, forest))


def find_max_survival_days(n, forest):
    dp = [[0] * n for _ in range(n)]
    max_survival_days = 1
    for row in range(n):
        for col in range(n):
            if dp[row][col]:
                continue
            dfs(row, col, n, dp, forest)
            if dp[row][col] > max_survival_days:
                max_survival_days = dp[row][col]
    return max_survival_days


def dfs(row, col, n, dp, forest):
    if dp[row][col]:
        return dp[row][col]
    max_days = 1
    if col + 1 < n and forest[row][col] < forest[row][col + 1]:
        days = 1 + dfs(row, col + 1, n, dp, forest)
        if days > max_days:
            max_days = days
    if col > 0 and forest[row][col] < forest[row][col - 1]:
        days = 1 + dfs(row, col - 1, n, dp, forest)
        if days > max_days:
            max_days = days
    if row + 1 < n and forest[row][col] < forest[row + 1][col]:
        days = 1 + dfs(row + 1, col, n, dp, forest)
        if days > max_days:
            max_days = days
    if row > 0 and forest[row][col] < forest[row - 1][col]:
        days = 1 + dfs(row - 1, col, n, dp, forest)
        if days > max_days:
            max_days = days
    dp[row][col] = max_days
    return dp[row][col]


main()
