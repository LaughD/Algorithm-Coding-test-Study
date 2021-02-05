"""
    Code written on Feb 5, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 외벽 점검(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/60062
"""
from bisect import bisect_left, bisect_right
from collections import deque


def check(n, weak, p, d):    # p means point, d means distance
    base_point = bisect_left(weak, p)
    if p + d >= n:
        remaining_weak = weak[bisect_right(weak, (p+d) % n):base_point]
    else:
        remaining_weak = weak[:base_point] + weak[bisect_right(weak, p+d):]
    return remaining_weak


def solution(n, weak, dist):
    dist.sort()
    num_employees = 1
    past = set()
    queue = deque([tuple(weak)])
    while dist:
        distance = dist.pop()
        for _ in range(len(queue)):
            weak = queue.popleft()
            for point in weak:
                remaining_weak = check(n, weak, point, distance)
                if not remaining_weak:
                    return num_employees
                if remaining_weak not in past:
                    past.add(remaining_weak)
                    queue.append(remaining_weak)
        num_employees += 1
    return -1
