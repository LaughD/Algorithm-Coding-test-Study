"""
    Code written on May 12, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    07576번: 토마토
    link: https://www.acmicpc.net/problem/7576
"""
from collections import deque
from sys import stdin


def main():
    width, height = map(int, stdin.readline().split())
    q = deque()
    warehouse = []
    unripe = 0
    for row in range(height):
        warehouse.append(stdin.readline().split())
        for col in range(width):
            if warehouse[row][col] == '1':
                q.append((row, col))
            elif warehouse[row][col] == '0':
                unripe += 1
    print_required_days(warehouse, q, unripe, height, width)


def print_required_days(warehouse, q, unripe, height, width):
    days = 0
    while q and unripe:
        for _ in range(len(q)):
            row, col = q.popleft()
            if row > 0 and warehouse[row - 1][col] == '0':
                warehouse[row - 1][col] = '1'
                unripe -= 1
                q.append((row - 1, col))
            if col > 0 and warehouse[row][col - 1] == '0':
                warehouse[row][col - 1] = '1'
                unripe -= 1
                q.append((row, col - 1))
            if row + 1 < height and warehouse[row + 1][col] == '0':
                warehouse[row + 1][col] = '1'
                unripe -= 1
                q.append((row + 1, col))
            if col + 1 < width and warehouse[row][col + 1] == '0':
                warehouse[row][col + 1] = '1'
                unripe -= 1
                q.append((row, col + 1))
        days += 1
    print(-1 if unripe else days)


main()
