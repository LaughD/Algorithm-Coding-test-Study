'''
    Code written on Aug 22, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    힙(Heap): 더 맵게(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42626
'''
import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    least_spicy = heapq.heappop(scoville)
    while least_spicy < K:
        if not scoville:
            return -1
        mixed = least_spicy + 2 * heapq.heappop(scoville)
        least_spicy = heapq.heappushpop(scoville, mixed)
        answer += 1
    return answer