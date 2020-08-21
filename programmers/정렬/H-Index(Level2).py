'''
    Code written on Aug 18, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    정렬: H-Index(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42747
'''
from collections import Counter, deque
def solution(citations):
    h = 0
    citations = deque(sorted(Counter(citations).items(), reverse=True))
    while citations:
        h += citations[0][-1]
        if citations[0][0] >= h:
            if len(citations) == 1 or h >= citations[1][0]:
                return h
        else:
            return citations[0][0]
        citations.popleft()