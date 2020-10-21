'''
    Code written on Oct 21, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 124 나라의 숫자(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12899
'''
from collections import deque

def solution(n):
    queue = deque()
    while n >= 3:
        mod = n % 3
        n //= 3
        if not mod:
            n -= 1
            mod = 4
        queue.appendleft(str(mod))
    if n:
        queue.appendleft(str(n))
    return ''.join(queue)
