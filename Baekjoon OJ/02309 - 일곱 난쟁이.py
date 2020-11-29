'''
    Code written on Nov 29, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    02309번: 일곱 난쟁이
    link: https://www.acmicpc.net/problem/2309
'''
from sys import stdin
from itertools import combinations

numbers = sorted(map(int, stdin.readlines()))
total = sum(numbers)
for case in combinations(numbers, 2):
    if sum(case) == total-100:
        for number in numbers:
            if number not in case:
                print(number)
        break
