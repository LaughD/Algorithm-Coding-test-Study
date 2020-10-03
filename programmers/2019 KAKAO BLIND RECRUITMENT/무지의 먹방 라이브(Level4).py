'''
    Code written on Oct 3, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 무지의 먹방 라이브(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/42891
'''
import heapq

def solution(food_times, k):
    food_times = list(zip(food_times, range(1, len(food_times)+1)))
    heapq.heapify(food_times)
    accumulate = 0
    while food_times:
        if k < len(food_times) * (food_times[0][0] - accumulate):
            break
        k -= len(food_times) * (food_times[0][0] - accumulate)
        accumulate = food_times[0][0]
        while food_times and accumulate == food_times[0][0]:
            heapq.heappop(food_times)
    if not food_times:
        return -1
    k = k % len(food_times)
    return sorted(food_times, key=lambda x: x[1])[k][1]
