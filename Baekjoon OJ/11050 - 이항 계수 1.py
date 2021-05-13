"""
    Code written on May 13, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    11050번: 이항 계수 1
    link: https://www.acmicpc.net/problem/11050
"""


def main():
    n, k = map(int, input().split())
    if k > n - k:
        k = n - k
    r = n
    for i in range(1, k):
        r -= 1
        n *= r
        k *= i
    print(n // k if k else 1)


main()
