"""
    Code written on Apr 15, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18511번: 큰 수 구성하기
    link: https://www.acmicpc.net/problem/18511
"""


def main():
    def dfs(value):
        nonlocal max_value
        if value <= n:
            if max_value < value:
                max_value = value
            for number in numbers:
                dfs(value * 10 + number)

    n, _ = map(int, input().split())
    numbers = list(map(int, input().split()))
    max_value = 0
    dfs(0)
    print(max_value)


main()
