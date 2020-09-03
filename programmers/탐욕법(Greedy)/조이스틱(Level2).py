'''
    Code written on Sep 4, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 조이스틱(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42860
'''
from copy import deepcopy
def solution(name):
    OVER_TRY = len(name)
    A, N = ord('A'), ord('N')
    name = list(name)
    answers = []
    stack = [(0, 0, 0, name)]
    while stack:
        attempt, idx, value, name = stack.pop()
        if attempt < OVER_TRY:
            this = ord(name[idx])
            value += (this - A - (this > N) * (this - N) * 2)
            name[idx] = 'A'
            if name.count('A') == OVER_TRY:
                answers.append(attempt + value)
            else:
                modified = deepcopy(name)
                stack.append((attempt+1, idx-1, value, name))
                stack.append((attempt+1, idx+1, value, modified))
    return min(answers)