'''
    Code written on Aug 25, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    힙(Heap): 디스크 컨트롤러(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42627
'''
import heapq
from collections import deque
def solution(jobs):
    REQUESTS = len(jobs)
    jobs = deque(sorted(jobs))
    requested = []
    total_tat = 0
    now = 0
    for _ in range(REQUESTS):
        if not requested and jobs[0][0]> now:
            now = jobs[0][0]
        while jobs and jobs[0][0] <= now:
            job = jobs.popleft()
            job.reverse()
            heapq.heappush(requested, job)
        job = heapq.heappop(requested)
        now += job[0]
        total_tat += now - job[-1]
    return total_tat // REQUESTS