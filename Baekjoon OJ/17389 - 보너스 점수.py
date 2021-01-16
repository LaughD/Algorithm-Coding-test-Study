"""
    Code written on Jan 16, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17389번: 보너스 점수
    link: https://www.acmicpc.net/problem/17389
"""
_ = input()
total = bonus = 0
for num, result in enumerate(input(), 1):
    if result == 'O':
        total += (num + bonus)
        bonus += 1
    else:
        bonus = 0
print(total)
