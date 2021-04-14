"""
    Code written on Apr 14, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01167번: 트리의 지름
    link: https://www.acmicpc.net/problem/1167
"""
from sys import stdin


def main():
    num_vertices = int(stdin.readline())
    tree = {vertex: {} for vertex in range(1, num_vertices + 1)}
    for _ in range(num_vertices):
        vertex, *edge_information = map(int, stdin.readline().split())
        for v in range(0, len(edge_information) - 1, 2):    # v: vertex index
            tree[vertex][edge_information[v]] = edge_information[v + 1]
    furthest_vertex, _ = get_farthest_vertex_and_distance(tree, num_vertices)
    print(get_farthest_vertex_and_distance(tree, furthest_vertex)[1])


def get_farthest_vertex_and_distance(tree, starting_vertex):
    visited = [False] * (len(tree) + 1)
    visited[starting_vertex] = True
    stack = [(starting_vertex, 0)]
    furthest_vertex = starting_vertex
    max_distance = 0

    while stack:
        vertex, distance = stack.pop()
        if distance > max_distance:
            max_distance = distance
            furthest_vertex = vertex
        for adjacent in tree[vertex]:    # adjacent: adjacent vertex
            if not visited[adjacent]:
                visited[adjacent] = True
                stack.append((adjacent, distance + tree[vertex][adjacent]))
    return furthest_vertex, max_distance


main()
