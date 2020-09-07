'''
    Code written on Sep 7, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 실패율(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42889
'''
from collections import Counter
def solution(N, stages):
    PLAYER = len(stages)
    stages = Counter(stages)
    stoppage = {}
    for stage in range(1, N+1):
        if stage in stages:
            stoppage[stage] = stages[stage] / PLAYER
            PLAYER -= stages[stage]
        else:
            stoppage[stage] = 0
    return sorted(stoppage, key=lambda x: stoppage[x], reverse=True)