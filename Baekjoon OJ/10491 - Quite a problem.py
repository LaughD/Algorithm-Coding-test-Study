'''
    Code written on Oct 24, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    10491번: Quite a problem
    link: https://www.acmicpc.net/problem/10491
'''
from sys import stdin
import re

keyword = re.compile("(.*problem.*)", re.I)
for line in stdin:
    if (keyword.match(line)):
        print("yes")
    else:
        print("no");
