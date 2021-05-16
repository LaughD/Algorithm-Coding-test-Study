"""
    Code written on May 16, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01005번: ACM Craft
    link: https://www.acmicpc.net/problem/1005
"""
from sys import setrecursionlimit, stdin


def main():
    setrecursionlimit(10_000)
    print(*(calc_build_time() for _ in range(int(stdin.readline()))), sep="\n")


def calc_build_time():
    def traceback(building):
        if acc_build_times[building] != -1:
            return acc_build_times[building]
        acc_build_time = 0
        for pre_building in rev_tech_tree[building]:
            acc_build_time = max(acc_build_time, traceback(pre_building))
        acc_build_times[building] = acc_build_time + build_times[building]
        return acc_build_times[building]

    num_buildings, num_rules = map(int, stdin.readline().split())
    build_times = [0] + list(map(int, stdin.readline().split()))
    acc_build_times = [-1] * (1 + num_buildings)    # acc: accumulated
    rev_tech_tree = [[] for _ in range(1 + num_buildings)]  # rev: reversed
    for _ in range(num_rules):
        pre, post = map(int, stdin.readline().split())
        rev_tech_tree[post].append(pre)
    return traceback(int(stdin.readline()))


main()
