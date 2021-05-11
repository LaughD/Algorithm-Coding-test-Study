"""
    Code written on May 11, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01753번: 최단경로
    link: https://www.acmicpc.net/problem/1753
"""
import heapq
from sys import stdin


def main():
    num_vertices, num_edges = map(int, stdin.readline().split())
    graph = [{} for _ in range(1 + num_vertices)]
    start_vertex = int(stdin.readline())
    for _ in range(num_edges):
        departure, destination, cost = map(int, stdin.readline().split())
        if destination in graph[departure] and graph[departure][destination] < cost:
            continue
        graph[departure][destination] = cost
    print_shortest_route_cost(start_vertex, graph, num_vertices)


def print_shortest_route_cost(start_vertex, graph, num_vertices):
    cost_list = [200_000] * (1 + num_vertices)
    cost_list[start_vertex] = 0
    heap = [(0, start_vertex)]
    while heap:
        cost, vertex = heapq.heappop(heap)
        if cost_list[vertex] < cost:
            continue
        for adj_vertex, adj_cost in graph[vertex].items():    # adj: adjacent
            adj_cost += cost
            if adj_cost < cost_list[adj_vertex]:
                cost_list[adj_vertex] = adj_cost
                heapq.heappush(heap, (adj_cost, adj_vertex))

    for cost in cost_list[1:]:
        print("INF" if cost == 200_000 else cost)


main()
