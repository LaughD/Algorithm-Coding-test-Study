"""
    Code written on Feb 13, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01715번: 카드 정렬하기
    link: https://www.acmicpc.net/problem/1715
"""
import heapq
from sys import stdin


n = int(stdin.readline())
heap = [int(stdin.readline()) for _ in range(n)]

heapq.heapify(heap)
total = 0
while len(heap) > 1:
    comparison = heapq.heappop(heap) + heap[0]
    total += comparison
    heapq.heappushpop(heap, comparison)
print(total)
