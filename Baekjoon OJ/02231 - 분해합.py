"""
    Code written on Dec 30, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    02231번: 분해합
    link: https://www.acmicpc.net/problem/2231
"""
from sys import stdin


target = stdin.readline().rstrip()
target_num = int(target)
digits = []

if target_num >= 17:
    glb = target_num - 9 * len(target)
else:
    glb = target_num - 9 * (len(target)-1)

lub = target_num
for n in reversed(range(len(target))):
    quotient, lub = divmod(lub, 1+(10**n))
    digits.append(quotient)
lub = int(''.join(map(str, digits)))

min_constructor = 0
for num in range(glb, 1+lub):
    decomposition_sum = num
    decomposition_sum += sum([int(i) for i in str(num)])
    if decomposition_sum == target_num:
        min_constructor = num
        break

print(min_constructor)
