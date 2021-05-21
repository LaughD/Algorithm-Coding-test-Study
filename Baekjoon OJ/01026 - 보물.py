"""
    Code written on May 21, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01026번: 보물
    link: https://www.acmicpc.net/problem/1026
"""


def main():
    _ = input()
    array_a = list(map(int, input().split()))
    array_b = list(map(int, input().split()))
    array_a.sort()
    array_b.sort()
    print(sum(element * array_b.pop() for element in array_a))


main()
