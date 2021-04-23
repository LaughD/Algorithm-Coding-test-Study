"""
    Code written on Apr 23, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2021 KAKAO BLIND RECRUITMENT: 순위 검색(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/72412
"""
from bisect import bisect_left


def solution(info, query):
    answer = []
    statistics = {}
    for application in info:
        application = application.split()
        score = int(application.pop())
        record_score(application, score, statistics, -1)
    for scores in statistics.values():
        scores.sort()
    for q in query:
        q = q.split()
        score = int(q.pop())
        q = tuple(q[0::2])
        if q in statistics:
            answer.append(len(statistics[q]) - bisect_left(statistics[q], score))
        else:
            answer.append(0)
    return answer


def record_score(application, score, statistics, item_index):
    _application = tuple(application)
    if _application not in statistics:
        statistics[_application] = []
    statistics[_application].append(score)
    for next_index in range(1 + item_index, 4):
        if application[next_index] != '-':
            application[next_index], item = '-', application[next_index]
            record_score(application, score, statistics, next_index)
            application[next_index] = item
