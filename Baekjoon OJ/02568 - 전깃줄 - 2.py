"""
    Python Version: Python 3.9.4
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02568 - 전깃줄 - 2, https://www.acmicpc.net/problem/2568
"""
from bisect import bisect_left
from sys import stdin


def main():
    num_wires = int(stdin.readline())
    wires = [tuple(map(int, stdin.readline().split())) for _ in range(num_wires)]
    wires.sort()
    utility_pole_a_positions = []
    utility_pole_b_positions = []
    utility_pole_a_index = []

    for utility_pole_a_position, utility_pole_b_position in wires:
        index = bisect_left(utility_pole_b_positions, utility_pole_b_position)
        if len(utility_pole_b_positions) == index:
            utility_pole_a_positions.append(utility_pole_a_position)
            utility_pole_b_positions.append(utility_pole_b_position)
        else:
            utility_pole_a_positions[index] = utility_pole_a_position
            utility_pole_b_positions[index] = utility_pole_b_position
        utility_pole_a_index.append(index)

    left_wire_index = len(utility_pole_b_positions) - 1
    stack = []
    for index in range(num_wires - 1, -1, -1):
        if utility_pole_a_index[index] == left_wire_index:
            left_wire_index -= 1
        else:
            stack.append(f"{wires[index][0]}")
    print(len(stack))
    print(*stack[::-1], sep="\n")


main()
