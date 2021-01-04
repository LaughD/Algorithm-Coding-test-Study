"""
    Code written on Jan 5, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17298번: 오큰수
    link: https://www.acmicpc.net/problem/17298
"""
from sys import stdin


size = int(stdin.readline())
nums = list(map(int, stdin.readline().split()))

nge = ['-1'] * size
stack = [0]
stack_head = 0
for i in range(1, size):
    if stack:
        while stack and nums[stack_head] < nums[i]:
            nge[stack.pop()] = str(nums[i])
            if stack:
                stack_head = stack[-1]
    stack.append(i)
    stack_head = i

print(' '.join(nge))
