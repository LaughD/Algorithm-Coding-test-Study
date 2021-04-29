"""
    Code written on Apr 29, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    12784번: 인하니카 공화국
    link: https://www.acmicpc.net/problem/12784
"""
from sys import stdin


def main():
    num_test_cases = int(stdin.readline())
    print("\n".join(
        f"{get_min_cost(1, *get_world_map())}" for _ in range(num_test_cases)
    ))


def get_world_map():
    num_islands, num_bridges = map(int, stdin.readline().split())
    world_map = {island: [] for island in range(1, 1 + num_islands)}
    for _ in range(num_bridges):
        island_a, island_b, cost = map(int, stdin.readline().split())
        world_map[island_a].append((island_b, cost))
        world_map[island_b].append((island_a, cost))
    visited = [False] * (1 + num_islands)
    visited[1] = True
    return world_map, visited


def get_min_cost(island, world_map, visited):
    # adj_island: adjacent island
    min_cost = 0
    for adj_island, cost in world_map[island]:
        if visited[adj_island]:
            continue
        visited[adj_island] = True
        if len(world_map[adj_island]) > 1:
            min_sub_cost = get_min_cost(adj_island, world_map, visited)
            if min_sub_cost < cost:
                cost = min_sub_cost
        min_cost += cost
    return min_cost


main()
