'''
    Code written on Aug 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    스택/큐: 프린터(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42587
'''
from collections import deque
def solution(priorities, location):
    queue = deque(sorted(priorities, reverse=True))
    priorities = deque(enumerate(priorities))
    count = 0
    while True:
        head = priorities.popleft()
        if queue[0] == head[-1]:
            count += 1
            if location == head[0]:
                break
            queue.popleft()
        else:
            priorities.append(head)      
    return count