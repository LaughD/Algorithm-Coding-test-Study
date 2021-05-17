"""
    Code written on May 17, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10799번: 쇠막대기
    link: https://www.acmicpc.net/problem/10799
"""


def main():
    past_bar = current_num_bar = total_num_bar = 0
    for bar in input().rstrip():
        if bar == ')':
            current_num_bar -= 1
            if past_bar == '(':
                total_num_bar += current_num_bar - 1
        else:
            current_num_bar += 1
            total_num_bar += 1
        past_bar = bar
    print(total_num_bar)


main()
