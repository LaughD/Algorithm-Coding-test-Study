'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    01620번: 나는야 포켓몬 마스터 이다솜
    link: https://www.acmicpc.net/problem/1620
'''
from sys import stdin


digit, quest = map(int, stdin.readline().split())
d_to_n = {}
n_to_d = {}
for i in range(1, digit+1):
    pokemon = stdin.readline().rstrip()
    n_to_d[pokemon] = i
    d_to_n[i] = pokemon
for i in range(quest):
    q = stdin.readline().rstrip()
    if q.isdecimal():
        print(f'{d_to_n[int(q)]}')
    else:
        print(f'{n_to_d[q]}')
