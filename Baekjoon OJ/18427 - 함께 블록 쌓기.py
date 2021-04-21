"""
    Code written on Apr 21, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18427번: 함께 블록 쌓기
    link: https://www.acmicpc.net/problem/18427
"""
from sys import stdin


def main():
    num_students, _, target_height = map(int, stdin.readline().split())
    dp = [1] + [0] * target_height
    for _ in range(num_students):
        block_height_set = tuple(map(int, stdin.readline().split()))
        for height in range(target_height, 0, -1):
            for block_height in block_height_set:
                if height < block_height:
                    continue
                dp[height] += dp[height - block_height]
    print(dp[-1] % 10_007)


main()
