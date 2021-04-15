"""
    Code written on Apr 15, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18404번: 현명한 나이트
    link: https://www.acmicpc.net/problem/18404
"""
from collections import deque
from sys import stdin


def main():
    read = stdin.readline
    board_size, num_pieces = map(int, read().split())
    knight = tuple(map(int, read().split()))
    pieces = (tuple(map(int, read().split())) for _ in range(num_pieces))
    min_num_moves = get_min_num_moves(board_size, knight)
    print(*(min_num_moves[x][y] for x, y in pieces))


def get_min_num_moves(board_size, knight):
    min_num_moves = [[0] * (board_size + 1) for _ in range(board_size + 1)]
    movement_directions = ((-2, -1), (-2, 1), (-1, -2), (-1, 2),
                           (1, -2), (1, 2), (2, -1), (2, 1))
    num_moves = 1
    queue = deque([knight])
    while queue:
        for _ in range(len(queue)):
            knight_x, knight_y = queue.popleft()
            for dx, dy in movement_directions:
                nx = knight_x + dx
                ny = knight_y + dy
                if 0 < nx <= board_size and 0 < ny <= board_size:
                    if min_num_moves[nx][ny]:
                        continue
                    min_num_moves[nx][ny] = num_moves
                    queue.append((nx, ny))
        num_moves += 1
    return min_num_moves


main()
