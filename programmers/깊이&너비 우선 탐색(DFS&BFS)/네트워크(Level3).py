'''
    Code written on Sep 6, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    깊이/너비 우선 탐색(DFS/BFS): 네트워크(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43162
'''
from collections import defaultdict
def solution(n, computers):
    visited = set()
    graph = defaultdict(list)
    for i in range(n):
        for j in range(i+1, n):
            if computers[i][j]:
                graph[i].append(j)
                graph[j].append(i)
    network = 0
    for node in range(n):
        if node not in visited:
            network += 1
            stack = [node]
            while stack:
                this = stack.pop()
                if this not in visited:
                    visited.add(this)
                    stack.extend(graph[this])
    return network

'''
    Code written on ???, 2020
    제출 기록은 있으나, 작성일이 기억나지 않음. 2020년 초 무렵으로 추정.
'''
# from collections import deque

# def setting(n, computers):
#     graph = {i:set() for i in range(n)}
#     for i in range(n-1):
#         for j in range(i+1, n):
#             if computers[i][j]:
#                 graph[i].add(j)
#                 graph[j].add(i)
#     return graph

# def bfs(graph, root, visited):
#     subnet = set()
#     queue = deque([root])
#     while queue:
#         n = queue.popleft()
#         if n not in subnet:
#             subnet.add(n)
#             queue.extend(graph[n])
#     return subnet

# def solution(n, computers):
#     graph = setting(n, computers)
#     visited = set()
#     network = []
#     for root in range(n):
#         if root not in visited:
#             subnet = bfs(graph, root, visited)
#             visited.update(subnet)
#             network.append(subnet)
#     return len(network)