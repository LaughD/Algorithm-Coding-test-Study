'''
    Code written on Aug 12, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    스택/큐: 기능개발(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42586
'''
from math import ceil
def solution(progresses, speeds):
    answer = []
    count = 0
    ahead = ceil((100 - progresses[0]) / speeds[0])
    for progress, speed in zip(progresses, speeds):
        day = ceil((100 - progress) / speed)
        if ahead >= day:
            count += 1
        else:
            answer.append(count)
            count = 1
            ahead = day
    answer.append(count)
    return answer