'''
    Code written on Aug 27, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 캐시(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17680
'''
from collections import deque
def solution(cacheSize, cities):
    time = 0
    cache = deque(maxlen=cacheSize)
    if not cacheSize:
        return len(cities) * 5
    for city in map(lambda x: x.lower(), cities):
        if city in cache:
            cache.remove(city)
            time += 1
        else:
            time += 5
        cache.append(city)
    return time