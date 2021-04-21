"""
    Code written on Apr 21, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18513번: 샘터
    link: https://www.acmicpc.net/problem/18513
"""
from collections import deque


def main():
    num_fountains, num_houses = map(int, input().split())
    constructions = set(map(int, input().split()))

    unhappiness = 0
    queue = deque(zip(constructions, [1] * num_fountains))
    while queue:
        fountain, distance = queue.popleft()
        left_space = fountain - distance
        right_space = fountain + distance
        was_built = False
        if left_space not in constructions:
            constructions.add(left_space)
            num_houses -= 1
            unhappiness += distance
            was_built = True
        if not num_houses:
            break
        if right_space not in constructions:
            constructions.add(right_space)
            num_houses -= 1
            unhappiness += distance
            was_built = True
        if not num_houses:
            break
        if was_built:
            queue.append((fountain, distance + 1))
    print(unhappiness)


main()
