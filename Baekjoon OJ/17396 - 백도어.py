"""
    Code written on Jan 22, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17396번: 백도어
    link: https://www.acmicpc.net/problem/17396
"""
import heapq
from collections import defaultdict
from sys import maxsize, stdin


num_junctions, num_ways = map(int, stdin.readline().split())

junctions = stdin.readline().split()
junctions[-1] = '0'

times = [maxsize] * num_junctions
times[0] = 0

heap = [(0, 0)]    # (0: travel time, 0: starting point)

graph = defaultdict(list)
for _ in range(num_ways):  # In "j1" and "j2", 'j' means "junction"
    j1, j2, time = map(int, stdin.readline().split())
    if '0' == junctions[j1] == junctions[j2]:
        graph[j1].append((time, j2))
        graph[j2].append((time, j1))

while heap:    # "cur" means "current"
    cur_time, cur_junction = heapq.heappop(heap)
    if cur_time <= times[cur_junction]:
        for addition_time, next_junction in graph[cur_junction]:
            if (next_time := cur_time + addition_time) < times[next_junction]:
                times[next_junction] = next_time
                heapq.heappush(heap, (next_time, next_junction))

print(times.pop() if times[-1] != maxsize else -1)
