'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    01920번: 수 찾기
    link: https://www.acmicpc.net/problem/1920
'''
from sys import stdin, stdout


_1 = stdin.readline()
ns = set(stdin.readline().split())
_2 = stdin.readline()
for n in stdin.readline().split():
    stdout.write('1\n') if n in ns else stdout.write('0\n')