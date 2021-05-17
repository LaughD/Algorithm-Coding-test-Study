"""
    Code written on May 17, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01389번: 케빈 베이컨의 6단계 법칙
    link: https://www.acmicpc.net/problem/1389
"""
from collections import deque
from sys import stdin


def main():
    num_user, num_relationship = map(int, stdin.readline().split())
    num_user += 1
    relationship = [set() for _ in range(num_user)]
    for _ in range(num_relationship):
        user_a, user_b = map(int, stdin.readline().split())
        relationship[user_a].add(user_b)
        relationship[user_b].add(user_a)
    print_min_bacon_number_user(relationship, num_user)


def print_min_bacon_number_user(relationship, num_user):
    min_bacon_number = 10_000
    min_bacon_number_user = 1
    for user in range(1, num_user):
        bacon_number = calc_bacon_number(user, relationship, [False] * num_user)
        if min_bacon_number > bacon_number:
            min_bacon_number = bacon_number
            min_bacon_number_user = user
    print(min_bacon_number_user)


def calc_bacon_number(user, relationship, checked):
    checked[user] = True
    q = deque([user])
    step_sum = step = 0
    while q:
        for _ in range(len(q)):
            user = q.popleft()
            step_sum += step
            for friend in relationship[user]:
                if checked[friend]:
                    continue
                checked[friend] = True
                q.append(friend)
        step += 1
    return step_sum


main()
