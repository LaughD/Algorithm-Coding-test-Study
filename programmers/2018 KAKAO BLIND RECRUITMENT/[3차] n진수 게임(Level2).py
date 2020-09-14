'''
    Code written on Sep 15, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [3차] n진수 게임(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17687
'''
from collections import deque
def solution(n, t, m, p):
    trans = {
        0: '0', 1: '1', 2: '2', 3: '3', 4: '4', 5: '5', 6: '6', 7: '7', 
        8: '8', 9: '9', 10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'}
    this, stack = 0, []
    condition = m * (t-1) + p
    while len(stack) < condition:
        queue = deque()
        num = this
        while num >= n:
            num, remainder = divmod(num, n)
            queue.appendleft(trans[remainder])
        queue.appendleft(trans[num])
        this += 1
        stack.extend(queue)
    return ''.join(stack)[p-1:p-1+m*t:m]
