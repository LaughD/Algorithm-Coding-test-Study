"""
    Code written on May 3, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17136번: 색종이 붙이기
    link: https://www.acmicpc.net/problem/17136
"""
from sys import stdin


def main():
    def update_min_num_papers_used(row, col, num_papers_used, area):
        nonlocal min_num_papers_used
        if num_papers_used >= min_num_papers_used:
            return
        if area == 0:
            min_num_papers_used = num_papers_used
            return
        if col == 10:
            if row != 9:
                update_min_num_papers_used(row + 1, 0, num_papers_used, area)
            return
        if big_paper[row][col]:
            for size in range(5, 0, -1):
                if can_attach_paper(row, col, size):
                    attach_paper(row, col, size)
                    area -= size ** 2
                    num_papers_used += 1
                    num_papers_available[size] -= 1
                    update_min_num_papers_used(row, col + size, num_papers_used, area)
                    num_papers_available[size] += 1
                    num_papers_used -= 1
                    area += size ** 2
                    detach_paper(row, col, size)
        else:
            update_min_num_papers_used(row, col + 1, num_papers_used, area)

    def can_attach_paper(row, col, size):
        if num_papers_available[size] == 0 or row + size > 10 or row + size > 10:
            return False
        for r in range(row, row + size):
            if size != sum(big_paper[r][col:col + size]):
                return False
        return True

    def attach_paper(row, col, size):
        for r in range(row, row + size):
            big_paper[r][col:col + size] = [0] * size

    def detach_paper(row, col, size):
        for r in range(row, row + size):
            big_paper[r][col:col + size] = [1] * size

    big_paper = []
    space_area = 0
    for _ in range(10):
        big_paper.append(list(map(int, stdin.readline().split())))
        space_area += sum(big_paper[-1])

    num_papers_available = [0, 5, 5, 5, 5, 5]
    min_num_papers_used = 26
    update_min_num_papers_used(0, 0, 0, space_area)
    print(min_num_papers_used if min_num_papers_used != 26 else -1)


main()
