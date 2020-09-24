'''
    Code written on Sep 24, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 추석 트래픽(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/17676
'''
from datetime import datetime, timedelta

def solution(lines):
    time_table = []
    for num, line in enumerate(lines, 1):
        date, time, duration = line.split()
        end = datetime.strptime(''.join(date + ' ' + time), "%Y-%m-%d %H:%M:%S.%f") + timedelta(seconds=0.999)
        start = end - timedelta(seconds=float(duration[:-1])+0.998)
        time_table.append((end, 1))
        time_table.append((start, 0))

    max_throughput = throughput = 0
    for time in sorted(time_table):
        if time[1]:
            throughput -= 1
        else:
            throughput += 1
        max_throughput = max(max_throughput, throughput)
    return max_throughput