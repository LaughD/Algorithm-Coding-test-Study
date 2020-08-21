'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    09012번: 괄호
    link: https://www.acmicpc.net/problem/9012
'''
from sys import stdin


num = int(stdin.readline().strip())
for count in range(num):
    sentence = stdin.readline().strip()
    score = 0
    for char in sentence:
        if char == '(':
            score += 1
        else:
            score -= 1
            if score < 0:
                break
    if score == 0:
        print("YES")
    else:
        print("NO")
