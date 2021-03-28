"""
    Code written on Mar 28, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    11728번: 배열 합치기
    link: https://www.acmicpc.net/problem/11728
"""
from sys import stdin


def main():
    a_size, b_size = map(int, stdin.readline().split())
    a_array = list(map(int, stdin.readline().split()))
    b_array = list(map(int, stdin.readline().split()))
    array = [0] * (a_size + b_size)
    array_index = 0

    a_pointer = b_pointer = 0
    while a_pointer < a_size and b_pointer < b_size:
        if a_array[a_pointer] <= b_array[b_pointer]:
            array[array_index] = a_array[a_pointer]
            a_pointer += 1
        else:
            array[array_index] = b_array[b_pointer]
            b_pointer += 1
        array_index += 1

    while a_pointer < a_size:
        array[array_index] = a_array[a_pointer]
        a_pointer += 1
        array_index += 1
    
    while b_pointer < b_size:
        array[array_index] = b_array[b_pointer]
        b_pointer += 1
        array_index += 1
    
    print(*array)


main()
