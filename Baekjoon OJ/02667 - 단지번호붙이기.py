"""
    Code written on May 10, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02667번: 단지번호붙이기
    link: https://www.acmicpc.net/problem/2667
"""
from sys import stdin


def main():
    size = int(stdin.readline())
    world = [list(stdin.readline().rstrip()) for _ in range(size)]
    print(*investigate_block_info(world, size), sep="\n")


def investigate_block_info(world, size):
    num_blocks = 0
    num_houses_in_blocks = []
    for row in range(size):
        for col in range(size):
            if world[row][col] == '0':
                continue
            num_blocks += 1
            num_houses_in_blocks.append(count_num_houses(world, size, row, col))
    num_houses_in_blocks.sort()
    return num_blocks, *num_houses_in_blocks


def count_num_houses(world, size, row, col):
    world[row][col] = '0'
    num_houses = 1
    if row > 0 and world[row - 1][col] == '1':
        num_houses += count_num_houses(world, size, row - 1, col)
    if row + 1 < size and world[row + 1][col] == '1':
        num_houses += count_num_houses(world, size, row + 1, col)
    if col > 0 and world[row][col - 1] == '1':
        num_houses += count_num_houses(world, size, row, col - 1)
    if col + 1 < size and world[row][col + 1] == '1':
        num_houses += count_num_houses(world, size, row, col + 1)
    return num_houses


main()
