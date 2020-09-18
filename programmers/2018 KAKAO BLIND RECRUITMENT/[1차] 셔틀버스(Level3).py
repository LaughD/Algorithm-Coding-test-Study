'''
    Code written on Sep 19, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 셔틀버스(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/17678
'''
from collections import deque
from datetime import timedelta

def solution(n, t, m, timetable):
    timetable = deque(map(lambda x: timedelta(hours=int(x[:2]), minutes=int(x[3:])), sorted(timetable)))
    bus_interval = timedelta(minutes=t)
    arrived_time = timedelta(hours=9, minutes=0) - bus_interval
    
    for _ in range(n):
        arrived_time += bus_interval
        seat_num = m
        for _ in range(m):
            if seat_num and timetable and arrived_time >= timetable[0]:
                cut_time = timetable.popleft()
                seat_num -= 1
            else:
                break
        if seat_num:
            cut_time = arrived_time
        else:
            cut_time -= timedelta(minutes=1)
            
    cut_time = str(cut_time)[:-3]
    if cut_time[1] == ':':
        cut_time = '0' + cut_time
    return cut_time