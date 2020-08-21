'''
    Code written on Aug 14, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    스택/큐: 다리를 지나는 트럭(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42583
'''
from collections import deque
def solution(bridge_length, weight, truck_weights):
    truck_weights = deque(truck_weights)
    running = deque()
    time = 0
    while truck_weights:
        if weight >= truck_weights[0]:
            weight -= truck_weights[0]
            running.append([truck_weights.popleft(), time])
            time += 1
        else:
            finished = running.popleft()
            weight += finished[0]
            if finished[-1] + bridge_length > time:
                time = finished[-1] + bridge_length
    time = running[-1][-1] + bridge_length + 1
    return time