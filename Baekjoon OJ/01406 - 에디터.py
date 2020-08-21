'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    01406번: 에디터
    link: https://www.acmicpc.net/problem/1406
'''
from sys import stdin


str1 = list(stdin.readline().rstrip())
str2 = []
count = int(input())
for i in range(count):
    command = stdin.readline().rstrip()
    if command == 'L':
        if str1:
            str2.append(str1.pop())
        else:
            continue
    elif command == 'D':
        if str2:
            str1.append(str2.pop())
        else:
            continue
    elif command == 'B':
        if str1:
            str1.pop()
        else:
            continue
    else:
        str1.append(command[-1])

print(f"{''.join(str1 + str2[::-1])}")
