"""
    Code written on Mar 14, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02887번: 행성 터널
    link: https://www.acmicpc.net/problem/2887
"""
from sys import stdin


def main():
    n = int(stdin.readline())
    parent = [planet_index for planet_index in range(n)]

    planet_coordinates = [[], [], []]
    for planet_index in range(n):
        x, y, z = map(int, stdin.readline().split())
        planet_coordinates[0].append((x, planet_index))
        planet_coordinates[1].append((y, planet_index))
        planet_coordinates[2].append((z, planet_index))

    tunnels = []
    for dimension in range(3):
        planet_coordinates[dimension].sort()
        this_dimension = planet_coordinates[dimension]
        for i in range(n - 1):
            planet_a = this_dimension[i]
            planet_b = this_dimension[i + 1]
            tunnels.append(
                (abs(planet_a[0] - planet_b[0]), planet_a[1], planet_b[1])
            )
    tunnels.sort()

    tunnel_count = 0
    cost_sum = 0
    for cost, planet_a, planet_b in tunnels:
        if find_parent(parent, planet_a) != find_parent(parent, planet_b):
            union_parent(parent, planet_a, planet_b)
            tunnel_count += 1
            cost_sum += cost
            if tunnel_count == n:
                break
    print(cost_sum)


def union_parent(parent, planet_a, planet_b):
    planet_a = find_parent(parent, planet_a)
    planet_b = find_parent(parent, planet_b)
    if planet_a < planet_b:
        parent[planet_b] = planet_a
    else:
        parent[planet_a] = planet_b


def find_parent(parent, planet):
    if parent[planet] != planet:
        parent[planet] = find_parent(parent, parent[planet])
    return parent[planet]


main()
