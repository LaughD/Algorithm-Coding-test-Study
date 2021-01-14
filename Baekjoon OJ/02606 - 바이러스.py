"""
    Code written on Jan 14, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02606번: 바이러스
    link: https://www.acmicpc.net/problem/2606
"""
from sys import stdin


graph = {node: set() for node in range(1, 1+int(stdin.readline()))}
for _ in range(int(stdin.readline())):
    node1, node2 = map(int, stdin.readline().split())
    graph[node1].add(node2)
    graph[node2].add(node1)

num_infected = -1
stack = [1]
visited = {1}
while stack:
    num_infected += 1
    for neighbor in graph[stack.pop()]:
        if neighbor not in visited:
            visited.add(neighbor)
            stack.append(neighbor)
print(num_infected)
