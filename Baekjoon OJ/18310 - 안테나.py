"""
    Code written on Feb 12, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18310번: 안테나
    link: https://www.acmicpc.net/problem/18310
"""
n = int(input())
houses = list(map(int, input().split()))
houses.sort()
print(houses[(n-1)//2])
