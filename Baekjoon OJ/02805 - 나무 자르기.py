"""
    Python Version: Python 3.9.4
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02805 - 나무 자르기, https://www.acmicpc.net/problem/2805
"""
from collections import Counter
from sys import stdin


def main():
    num_trees, target_len = map(int, stdin.readline().split())
    tree_counter = Counter(map(int, stdin.readline().split())).most_common()
    min_height = 0
    max_height = max(tree_counter)[0]

    while min_height <= max_height:
        mid_height = (min_height + max_height) // 2
        obtained_len = 0
        for tree_height, num in tree_counter:
            if tree_height > mid_height:
                obtained_len += (tree_height - mid_height) * num
        if obtained_len >= target_len:
            min_height = mid_height + 1
        else:
            max_height = mid_height - 1
    print(max_height)


main()
