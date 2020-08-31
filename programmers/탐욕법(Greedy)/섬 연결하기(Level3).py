'''
    Code written on Aug 31, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 섬 연결하기(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42861
'''
def solution(n, costs):
    nodes = {node : node for node in range(n)}
    edges = 0
    weights = 0
    for cost in sorted(costs, key=lambda x: x[-1]):
        if edges == n-1:
            break
        node1, node2, weight = cost
        if nodes[node1] != nodes[node2]:
            small = min(nodes[node1], nodes[node2])
            large = max(nodes[node1], nodes[node2])
            for node in nodes:
                if nodes[node] == small:
                    nodes[node] = large
            weights += weight
            edges += 1
    return weights