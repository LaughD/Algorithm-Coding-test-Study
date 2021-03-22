"""
    Code written on Mar 22, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02632번: 피자판매
    link: https://www.acmicpc.net/problem/2632
"""
from sys import stdin


def main():
    desired_size = int(stdin.readline())
    num_slices_a, num_slices_b = map(int, stdin.readline().split())
    a_sizes = get_pizza_sizes(num_slices_a)
    b_sizes = get_pizza_sizes(num_slices_b)
    num_cases = 0
    for a_size in a_sizes:
        if a_size <= desired_size:
            b_size = desired_size - a_size
            if b_size in b_sizes:
                num_cases += a_sizes[a_size] * b_sizes[b_size]
    print(num_cases)


def get_pizza_sizes(num_slices_pizza):
    slice_sizes = [0]
    slice_size = 0
    for _ in range(num_slices_pizza):
        slice_size += int(stdin.readline())
        slice_sizes.append(slice_size)
    pizza_size = slice_sizes[-1]
    for i in range(1, num_slices_pizza - 1):
        slice_sizes.append(pizza_size + slice_sizes[i])

    pizza_sizes = {0: 1, slice_sizes[num_slices_pizza]: 1}
    for i in range(1, num_slices_pizza):
        for j in range(i, i + num_slices_pizza):
            size = slice_sizes[j] - slice_sizes[j - i]
            if size in pizza_sizes:
                pizza_sizes[size] += 1
            else:
                pizza_sizes[size] = 1
    return pizza_sizes


main()
