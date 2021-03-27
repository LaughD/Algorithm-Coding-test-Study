"""
    Code written on Mar 27, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01922번: 네트워크 연결
    link: https://www.acmicpc.net/problem/1922
"""
from sys import stdin


def main():
    num_computers = int(stdin.readline())
    connection_information = [tuple(map(int, stdin.readline().split()))
                              for _ in range(int(stdin.readline()))]
    connection_information.sort(key=lambda x: x[2])
    parent_computer = [computer for computer in range(num_computers + 1)]
    total_cost = 0
    for computer1, computer2, cost in connection_information:
        if connect_computers(parent_computer, computer1, computer2):
            num_computers -= 1
            total_cost += cost
            if not num_computers:
                break
    print(total_cost)


def find_parent_computer(parent_computer, computer):
    if parent_computer[computer] != computer:
        parent_computer[computer] = \
            find_parent_computer(parent_computer, parent_computer[computer])
    return parent_computer[computer]


def connect_computers(parent_computer, computer1, computer2):
    computer1 = find_parent_computer(parent_computer, computer1)
    computer2 = find_parent_computer(parent_computer, computer2)
    if computer1 == computer2:
        return False
    elif computer1 < computer2:
        parent_computer[computer2] = computer1
    else:
        parent_computer[computer1] = computer2
    return True


main()
