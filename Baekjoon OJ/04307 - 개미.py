"""
    Code written on Mar 15, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    04307번: 개미
    link: https://www.acmicpc.net/problem/4307
"""
from sys import stdin


def main():
    answer = []
    for _ in range(int(stdin.readline())):
        # l means The length of the rod
        # n means Number of ants on the rod
        l, n = map(int, stdin.readline().split())
        fastest_fall_time = slowest_fall_time = 0
        for __ in range(n):
            left_cliff_distance = int(stdin.readline())
            right_cliff_distance = l - left_cliff_distance
            if left_cliff_distance <= right_cliff_distance:
                near_cliff_distance = left_cliff_distance
                distant_cliff_distance = right_cliff_distance
            else:
                near_cliff_distance = right_cliff_distance
                distant_cliff_distance = left_cliff_distance
            if fastest_fall_time < near_cliff_distance:
                fastest_fall_time = near_cliff_distance
            if slowest_fall_time < distant_cliff_distance:
                slowest_fall_time = distant_cliff_distance
        answer.append(f"{fastest_fall_time} {slowest_fall_time}")
    print("\n".join(answer))


main()
