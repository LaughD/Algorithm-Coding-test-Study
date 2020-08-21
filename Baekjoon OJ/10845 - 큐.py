'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    10845번: 큐
    link: https://www.acmicpc.net/problem/10845
'''
from sys import stdin
from collections import deque


queue = deque()
num = int(input())
for i in range(num):
    command = stdin.readline().strip()
    if command == 'pop':
        print(queue.popleft()) if queue else print(-1)
    elif command == 'size':
        print(len(queue))
    elif command == 'empty':
        print(0) if queue else print(1)
    elif command == 'front':
        print(queue[0]) if queue else print(-1)
    elif command == 'back':
        print(queue[-1]) if queue else print(-1)
    else:
        queue.append(int(command.split()[-1]))
