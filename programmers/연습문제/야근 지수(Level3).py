'''
    Code written on Oct 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 야근 지수(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12927
'''
import heapq

def solution(n, works):
    if sum(works) < n:
        return 0
    heap = []
    for work in works:
        heapq.heappush(heap, -work)    
    for _ in range(n):
        heapq.heappush(heap, heapq.heappop(heap) + 1)
    return sum(map(lambda x: x**2, heap))