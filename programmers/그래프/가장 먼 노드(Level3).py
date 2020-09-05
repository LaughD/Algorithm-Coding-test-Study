'''
    Code written on Sep 5, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    그래프: 가장 먼 노드(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/49189
'''
from collections import defaultdict, deque
def solution(n, edge):
    visited = defaultdict(int)
    graph = defaultdict(set)
    for nodes in edge:
        node1, node2 = nodes
        graph[node1].add(node2)
        graph[node2].add(node1)
    visited[1] = distance = 0
    queue = deque(graph[1])
    while queue:
        distance += 1
        nearest = len(queue)
        for _ in range(nearest):
            node = queue.popleft()
            if node not in visited:
                visited[node] = distance
                for neighbor in graph[node]:
                    queue.append(neighbor)
    max_distance = max(visited.values())
    return list(visited.values()).count(max_distance)