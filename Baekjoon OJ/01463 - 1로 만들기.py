"""
    Code written on May 1, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01463번: 1로 만들기
    link: https://www.acmicpc.net/problem/1463
"""
from collections import deque


def main():
    print(get_min_num_operations(int(input())))


def get_min_num_operations(integer):
    dp = {}
    q = deque([integer])
    count = 0
    while q:
        for _ in range(len(q)):
            number = q.popleft()
            if number == 1:
                return count
            if number % 2 == 0 and number % 2 not in dp:
                q.append(number // 2)
                dp[number // 2] = count + 1
            if number % 3 == 0 and number % 3 not in dp:
                q.append(number // 3)
                dp[number // 3] = count + 1
            if number - 1 not in dp:
                q.append(number - 1)
                dp[number - 1] = count + 1
        count += 1


main()
