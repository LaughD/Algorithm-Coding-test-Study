'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    05052번: 전화번호 목록
    link: https://www.acmicpc.net/problem/5052
'''
from sys import stdin


for i in range(int(stdin.readline().rstrip())):
    tel = [stdin.readline().rstrip() \
           for j in range(int(stdin.readline().rstrip()))]
    tel.sort()
    for x, y in zip(tel, tel[1:]):
        if y.startswith(x):
            print("NO")
            break
    else:
        print("YES")
