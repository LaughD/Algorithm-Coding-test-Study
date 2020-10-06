'''
    Code written on Oct 6, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2017 팁스타운: 짝지어 제거하기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12973
'''
from collections import deque

def solution(s):
    queue = deque()
    for char in s:
        if queue and queue[0] == char:
            queue.popleft()
        else:
            queue.appendleft(char)
    return 0 if queue else 1
