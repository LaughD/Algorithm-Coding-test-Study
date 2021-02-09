"""
    Code written on Feb 10, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    16234번: 인구 이동
    link: https://www.acmicpc.net/problem/16234
"""
from collections import deque
from sys import stdin


def bfs(i, j, population):
    global borderline_open
    queue = deque([(i, j, population)])
    union = [(i, j)]
    total_population = population
    num_countries = 1
    while queue:
        y, x, population = queue.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= nx < n and 0 <= ny < n and not visited[ny][nx] \
                    and l <= abs(population - countries[ny][nx]) <= r:
                queue.append((ny, nx, countries[ny][nx]))
                union.append((ny, nx))
                total_population += countries[ny][nx]
                num_countries += 1
                visited[ny][nx] = True
    if num_countries != 1:
        new_valid_locations.extend(union)
        borderline_open = True
        population = total_population // num_countries
        for y, x in union:
            countries[y][x] = population


n, l, r = map(int, stdin.readline().split())
countries = [list(map(int, stdin.readline().split())) for _ in range(n)]

valid_locations = ((i, j) for i in range(n) for j in range(n))
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
movement = 0
while True:
    visited = [[False] * n for _ in range(n)]
    new_valid_locations = []
    borderline_open = False
    for i, j in valid_locations:
        if not visited[i][j]:
            visited[i][j] = True
            bfs(i, j, countries[i][j])
    valid_locations = new_valid_locations
    if not borderline_open:
        break
    movement += 1
print(movement)
