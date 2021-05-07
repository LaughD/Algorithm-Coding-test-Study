"""
    Code written on May 7, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17406번: 배열 돌리기 4
    link: https://www.acmicpc.net/problem/17406
"""
from itertools import permutations
from sys import stdin


def main():
    height, width, num_rotation = map(int, stdin.readline().split())
    array = [[0] * (width + 1)]
    for _ in range(height):
        array.append([0] + list(map(int, stdin.readline().split())))
    print(calc_min_array_value(array, num_rotation))


def calc_min_array_value(array, num_rotation):
    min_array_value = 1e9
    rotations = [list(map(int, stdin.readline().split())) for _ in range(num_rotation)]
    for permutation in permutations(rotations, num_rotation):
        copied_array = [row[:] for row in array]
        for row, col, s in permutation:
            rotate_array(copied_array, row, col, s)
        for line in copied_array[1:]:
            array_value = sum(line)
            if min_array_value > array_value:
                min_array_value = array_value
    return min_array_value


def rotate_array(array, row, col, s):
    for distance in range(s, 0, -1):
        max_row = row + distance
        min_row = row - distance
        max_col = col + distance
        min_col = col - distance
        temp = array[min_row][min_col]
        for c in range(min_col + 1, max_col + 1):
            temp, array[min_row][c] = array[min_row][c], temp
        for r in range(min_row + 1, max_row + 1):
            temp, array[r][max_col] = array[r][max_col], temp
        for c in range(max_col - 1, min_col - 1, -1):
            temp, array[max_row][c] = array[max_row][c], temp
        for r in range(max_row - 1, min_row - 1, -1):
            temp, array[r][min_col] = array[r][min_col], temp


main()
