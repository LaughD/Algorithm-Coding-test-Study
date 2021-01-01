"""
    Code written on Jan 1, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01541번: 잃어버린 괄호
    link: https://www.acmicpc.net/problem/1541
"""
import re
from sys import stdin


expression = stdin.readline()
if '-' not in expression:
    print(sum(map(int, re.split("[+-]", expression))))
else:
    min_result = -sum(map(int, re.split("[+-]", expression)))
    for i in range(len(expression)):
        if expression[i] == '-':
            min_result += 2 * sum(map(int, expression[:i].split('+')))
            break
    print(min_result)
