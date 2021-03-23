"""
    Code written on Mar 23, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18429번: 근손실
    link: https://www.acmicpc.net/problem/18429
"""
# Solution 1: Using permutation
from itertools import permutations
from sys import stdin


def main():
    deadline, loss = map(int, stdin.readline().split())
    num_plans = 0
    for plan in permutations(map(int, stdin.readline().split()), deadline):
        weight = 500
        for increase in plan:
            weight += increase - loss
            if weight < 500:
                break
        else:
            num_plans += 1
    print(num_plans)


main()


# Solution 2: Using DFS
"""
from sys import stdin


def main():
    def get_num_plans(weight, day):
        if day == deadline:
            return 1
        num_plans = 0
        for kit_number in range(deadline):
            weight_tomorrow = weight - loss + kits[kit_number]
            if can_use_kit[kit_number] and weight_tomorrow >= 500:
                can_use_kit[kit_number] = False
                num_plans += get_num_plans(weight_tomorrow, day + 1)
                can_use_kit[kit_number] = True
        return num_plans

    deadline, loss = map(int, stdin.readline().split())
    kits = list(map(int, stdin.readline().split()))
    can_use_kit = [True] * deadline
    print(get_num_plans(500, 0))


main()
"""
