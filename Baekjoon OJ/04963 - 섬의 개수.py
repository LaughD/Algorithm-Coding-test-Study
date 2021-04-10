"""
    Code written on Apr 10, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    04963번: 섬의 개수
    link: https://www.acmicpc.net/problem/4963
"""
from collections import deque
from sys import stdin


def main():
    while True:
        width, height = map(int, stdin.readline().split())
        if width == height == 0:
            break
        map_ = [stdin.readline().split() for _ in range(height)]
        print(count_num_islands(map_, height, width))


def count_num_islands(map_, height, width):
    directions = ((-1, -1), (-1, 0), (-1, 1), (0, -1),
                  (0, 1), (1, -1), (1, 0), (1, 1))
    num_islands = 0
    for row in range(height):
        for col in range(width):
            if map_[row][col] == '0':
                continue
            map_[row][col] = '0'
            num_islands += 1
            queue = deque([(row, col)])
            while queue:
                r, c = queue.popleft()
                for dr, dc in directions:
                    next_row = r + dr
                    next_col = c + dc
                    if is_out_of_range(height, width, next_row, next_col):
                        continue
                    if map_[next_row][next_col] == '1':
                        map_[next_row][next_col] = '0'
                        queue.append((next_row, next_col))
    return num_islands


def is_out_of_range(height, width, row, col):
    if row < 0 or col < 0 or row >= height or col >= width:
        return True
    return False


main()
