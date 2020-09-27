'''
    Code written on Sep 27, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    깊이/너비 우선 탐색(DFS/BFS): 여행경로(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43164
'''
from collections import defaultdict, deque

def solution(tickets):
    graph = defaultdict(list)
    for departure, arrival in tickets:
        graph[departure].append(arrival)
    for city in graph:
        graph[city].sort(reverse=True)
    stack = ["ICN"]
    route = deque()
    while stack:
        city = stack.pop()
        if city not in graph or not graph[city]:
            route.appendleft(city)
        else:
            stack.append(city)
            stack.append(graph[city].pop())
    return list(route)
