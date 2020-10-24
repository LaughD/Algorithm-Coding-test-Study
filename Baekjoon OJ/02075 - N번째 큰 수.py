'''
    Code written on Oct 24, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    02075번: N번째 큰 수
    link: https://www.acmicpc.net/problem/2075
'''
from sys import stdin
import heapq

N = int(stdin.readline())
pq = []
for num in map(int, stdin.readline().split()):
    heapq.heappush(pq, num)
for _ in range(N-1):
    for num in map(int, stdin.readline().split()):
        heapq.heappush(pq, num)
        heapq.heappop(pq)
print(pq[0])
