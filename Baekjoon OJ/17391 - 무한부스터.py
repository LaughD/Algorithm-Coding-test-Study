"""
    Code written on Jan 17, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17391번: 무한부스터
    link: https://www.acmicpc.net/problem/17391
"""
from collections import deque
from sys import stdin


def bfs(game_map, destination):
    queue = deque([(0, 0)])
    visited = set()
    movement = 1
    while queue:
        for _ in range(len(queue)):
            row, col = queue.popleft()
            for moving in range(1, min(depth-row, 1+int(game_map[row][col]))):
                next_loc = (row + moving, col)    # next location
                if next_loc not in visited:
                    visited.add(next_loc)
                    if next_loc == destination:
                        return movement
                    queue.append(next_loc)
            for moving in range(1, min(width-col, 1+int(game_map[row][col]))):
                next_loc = (row, col + moving)    # next location
                if next_loc not in visited:
                    visited.add(next_loc)
                    if next_loc == destination:
                        return movement
                    queue.append(next_loc)
        movement += 1


depth, width = map(int, stdin.readline().split())
game_map = [stdin.readline().split() for _ in range(depth)]
destination = (depth-1, width-1)
print(bfs(game_map, destination))
