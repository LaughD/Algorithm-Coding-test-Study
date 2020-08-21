'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    10828번: 스택
    link: https://www.acmicpc.net/problem/10828
'''
from sys import stdin
from collections import deque


stack = deque()
num = int(input())
for i in range(num):
    command = stdin.readline().strip()
    if command == 'pop':
        print(stack.pop()) if stack else print(-1)
    elif command == 'size':
        print(len(stack))
    elif command == 'empty':
        print(0) if stack else print(1)
    elif command == 'top':
        print(stack[-1]) if stack else print(-1)
    else:
        stack.append(int(command.split()[-1]))
