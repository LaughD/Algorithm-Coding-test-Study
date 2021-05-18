"""
    Code written on May 18, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02493번: 탑
    link: https://www.acmicpc.net/problem/2493
"""


def main():
    num_towers = int(input())
    heights = [100_000_000] + list(map(int, input().split()))
    receiver = [0] * (1 + num_towers)
    stack = []
    for tower_idx in range(1, 1 + num_towers):
        height = heights[tower_idx]
        while stack and heights[stack[-1]] < height:
            stack.pop()
        if stack:
            receiver[tower_idx] = stack[-1]
        stack.append(tower_idx)
    print(*receiver[1:], sep=' ')


main()
