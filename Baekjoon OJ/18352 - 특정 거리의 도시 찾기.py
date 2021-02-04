"""
    Code written on Feb 4, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18352번: 특정 거리의 도시 찾기
    link: https://www.acmicpc.net/problem/18352
"""
from collections import deque
from sys import stdin


n, m, k, x = map(int, stdin.readline().split())

graph = [[] for _ in range(1 + n)]
for _ in range(m):    # dep means departure, arr means arrival
    dep, arr = map(int, stdin.readline().split())
    graph[dep].append(arr)

visited = [False] * (1 + n)
visited[x] = True

distance = 0
queue = deque([x])
while distance < k:
    for _ in range(len(queue)):
        dep = queue.popleft()
        for arr in graph[dep]:
            if not visited[arr]:
                visited[arr] = True
                queue.append(arr)
    distance += 1

answer = "\n".join(map(str, sorted(queue)))
print(answer) if answer else print(-1)
