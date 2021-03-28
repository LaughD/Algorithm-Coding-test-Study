"""
    Code written on Mar 28, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10409번: 서버
    link: https://www.acmicpc.net/problem/10409
"""
from sys import stdin


def main():
    num_processes, remaining_time = map(int, stdin.readline().split())
    processed = 0
    for time in map(int, stdin.readline().split()):
        remaining_time -= time
        if remaining_time < 0:
            break
        processed += 1
    print(processed)


main()
