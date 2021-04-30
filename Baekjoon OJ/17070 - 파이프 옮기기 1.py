"""
    Code written on Apr 30, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17070번: 파이프 옮기기 1
    link: https://www.acmicpc.net/problem/17070
"""
from sys import stdin


def main():
    read = stdin.readline
    home_size = int(read())
    home = [tuple(map(int, read().split())) for _ in range(home_size)]

    # 1st dimension: shape(0: horizontal, 1: vertical, 2: diagonal)
    # 2nd dimension: row
    # 3rd dimension: column
    dp = [[[0] * home_size for _ in range(home_size)] for _ in range(3)]

    for col in range(1, home_size):
        if home[0][col]:
            break
        dp[0][0][col] = 1

    for row in range(1, home_size):
        for col in range(2, home_size):
            if home[row][col]:
                continue
            dp[0][row][col] = dp[0][row][col-1] + dp[2][row][col-1]
            dp[1][row][col] = dp[1][row-1][col] + dp[2][row-1][col]
            if home[row][col-1] or home[row-1][col]:
                continue
            dp[2][row][col] = dp[0][row-1][col-1] + dp[1][row-1][col-1] + dp[2][row-1][col-1]

    print(dp[0][-1][-1] + dp[1][-1][-1] + dp[2][-1][-1])
    

main()
