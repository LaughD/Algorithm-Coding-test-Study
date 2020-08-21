'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    02920번: 음계
    link: https://www.acmicpc.net/problem/2920
'''
scale = input()[::2]
if scale == '12345678':
    print(f'ascending')
elif scale == '87654321':
    print(f'descending')
else:
    print('mixed')
