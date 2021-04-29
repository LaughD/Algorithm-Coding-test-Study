"""
    Code written on Apr 29, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02839번: 설탕 배달
    link: https://www.acmicpc.net/problem/2839
"""


def main():
    num_bags = [0] + [-1] * int(input())
    num_bags[3] = 1
    if len(num_bags) > 5:
        num_bags[5] = 1
    for weight in range(6, len(num_bags)):
        if num_bags[weight - 5] > 0:
            num_bags[weight] = num_bags[weight - 5] + 1
        elif num_bags[weight - 3] > 0:
            num_bags[weight] = num_bags[weight - 3] + 1
    print(num_bags[-1])


main()
