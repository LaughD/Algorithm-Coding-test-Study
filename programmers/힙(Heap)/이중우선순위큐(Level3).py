'''
    Code written on Aug 24, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    힙(Heap): 이중우선순위큐(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42628
'''
import heapq
def solution(operations):
    size = 0
    for operation in operations:
        if not size:
            min_heap, max_heap = [], []
        if operation.startswith('I'):
            heapq.heappush(min_heap, int(operation[2:]))
            heapq.heappush(max_heap, -int(operation[2:]))
            size += 1
        elif operation.startswith("D -") and size:
            heapq.heappop(min_heap)
            size -= 1
        elif operation.startswith('D') and size:
            heapq.heappop(max_heap)
            size -= 1
    if size:
        return [-heapq.heappop(max_heap) ,heapq.heappop(min_heap)]
    else:
        return [0, 0]