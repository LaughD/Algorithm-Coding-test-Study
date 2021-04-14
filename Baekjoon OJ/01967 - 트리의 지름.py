"""
    Code written on Apr 14, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01967번: 트리의 지름
    link: https://www.acmicpc.net/problem/1967
"""
from sys import stdin


def main():
    num_nodes = int(stdin.readline())
    tree = {1: {}}
    for _ in range(num_nodes - 1):
        parent, child, weight = map(int, stdin.readline().split())
        if child not in tree:
            tree[child] = {}
        tree[parent][child] = tree[child][parent] = weight
    farthest_node, _ = get_farthest_node_and_distance(tree, 1)
    print(get_farthest_node_and_distance(tree, farthest_node)[1])


def get_farthest_node_and_distance(tree, starting_node):
    visited = [False] * (len(tree) + 1)
    visited[starting_node] = True
    farthest_node = starting_node
    max_distance = 0

    stack = [(starting_node, 0)]
    while stack:
        node, distance = stack.pop()
        if distance > max_distance:
            farthest_node = node
            max_distance = distance
        for adjacent_node in tree[node]:
            if visited[adjacent_node]:
                continue
            visited[adjacent_node] = True
            stack.append(
                (adjacent_node, distance + tree[node][adjacent_node])
            )
    return farthest_node, max_distance


main()
