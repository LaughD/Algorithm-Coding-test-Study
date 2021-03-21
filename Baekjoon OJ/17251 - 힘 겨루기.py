"""
    Code written on Mar 21, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17251번: 힘 겨루기
    link: https://www.acmicpc.net/problem/17251
"""
from sys import stdin


def main():
    num_people = int(stdin.readline())
    strongest = red_no_win = blue_win = strength_index = 0
    for strength in map(int, stdin.readline().split()):
        if strength == strongest:
            red_no_win = strength_index
        elif strength > strongest:
            strongest = strength
            red_no_win = blue_win = strength_index
        strength_index += 1
        
    red_win = num_people - red_no_win - 1
    if red_win > blue_win:
        print('R')
    elif red_win == blue_win:
        print('X')
    else:
        print('B')


main()
