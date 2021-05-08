"""
    Code written on May 8, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17135번: 캐슬 디펜스
    link: https://www.acmicpc.net/problem/17135
"""
from collections import deque
from itertools import combinations
from sys import stdin


def main():
    height, width, arrow_range = map(int, stdin.readline().split())
    front_yard = []
    num_enemies = 0
    for _ in range(height):
        front_yard.append(list(map(int, stdin.readline().split())))
        for enemy in front_yard[-1]:
            if enemy:
                num_enemies += 1
    print(count_max_num_removed_enemies(front_yard, height, width, arrow_range, num_enemies))


def count_max_num_removed_enemies(front_yard, height, width, arrow_range, num_enemies):
    max_num_removed_enemies = 0
    arrow = 2
    for positions in combinations(range(width), 3):
        num_removed_enemies = 0
        for row in range(height - 1, -1, -1):
            removed_enemies = set()
            for col in positions:
                remove_enemy(front_yard, width, arrow_range, removed_enemies, arrow, row, col)
            for r, c in removed_enemies:
                front_yard[r][c] = arrow
            num_removed_enemies += len(removed_enemies)
        if num_removed_enemies == num_enemies:
            return num_enemies
        if max_num_removed_enemies < num_removed_enemies:
            max_num_removed_enemies = num_removed_enemies
        arrow += 1
    return max_num_removed_enemies


def remove_enemy(front_yard, width, arrow_range, removed_enemies, arrow, row, col):
    q = deque([(row, col)])
    checked = set()
    distance = 1
    while q and distance <= arrow_range:
        for _ in range(len(q)):
            r, c = q.popleft()
            if (r, c) in checked:
                continue
            checked.add((r, c))
            if front_yard[r][c] and front_yard[r][c] < arrow:
                removed_enemies.add((r, c))
                return
            if c >= 1:
                q.append((r, c - 1))
            if r >= 1:
                q.append((r - 1, c))
            if c + 1 < width:
                q.append((r, c + 1))
        distance += 1


main()
