"""
    Code written on Apr 14, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    월간 코드 챌린지 시즌1: 트리 트리오 중간값(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/68937
"""


def solution(n, edges):
    tree = {vertex: [] for vertex in range(1, n + 1)}
    for vertex1, vertex2 in edges:
        tree[vertex1].append(vertex2)
        tree[vertex2].append(vertex1)
    information = get_farthest_vertex_information(tree, 1)
    information = get_farthest_vertex_information(tree, information[0])
    if not information[2]:
        return information[1]
    information = get_farthest_vertex_information(tree, information[0])
    return information[1] - 1 if information[2] else information[1]


def get_farthest_vertex_information(tree, starting_vertex):
    visited = [False] * (len(tree) + 1)
    visited[starting_vertex] = True
    furthest_vertex = starting_vertex
    max_distance = 0
    is_unique = True

    stack = [(starting_vertex, 0)]
    while stack:
        vertex, distance = stack.pop()
        if distance == max_distance:
            is_unique = False
        elif distance > max_distance:
            max_distance = distance
            furthest_vertex = vertex
            is_unique = True
        for adjacent_vertex in tree[vertex]:
            if visited[adjacent_vertex]:
                continue
            visited[adjacent_vertex] = True
            stack.append((adjacent_vertex, distance + 1))
    return furthest_vertex, max_distance, is_unique
