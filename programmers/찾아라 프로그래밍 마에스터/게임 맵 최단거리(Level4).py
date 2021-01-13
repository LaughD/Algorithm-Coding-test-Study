"""
    Code written on Jan 13, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    찾아라 프로그래밍 마에스터: 게임 맵 최단거리(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/1844
"""
from collections import deque


def can_visit(next_loc, enemy_camp, maps):
    x, y = next_loc
    n, m = enemy_camp
    return (0 <= x <= n) and (0 <= y <= m) and maps[x][y]


def solution(maps):
    DIRS = ((0, 1), (0, -1), (1, 0), (-1, 0))  # EAST, WEST, SOUTH, NORTH
    queue = deque([(0, 0)])
    enemy_camp = (len(maps)-1, len(maps[0])-1)
    visited = set()
    moving_count = 0
    while queue:
        moving_count += 1
        for _ in range(len(queue)):
            cur_loc = queue.popleft()    # current location
            if cur_loc == enemy_camp:
                return moving_count
            for DIR in DIRS:
                next_loc = cur_loc[0]+DIR[0], cur_loc[1]+DIR[1]
                if can_visit(next_loc, enemy_camp, maps) \
                        and next_loc not in visited:
                    visited.add(next_loc)
                    queue.append(next_loc)
    return -1
