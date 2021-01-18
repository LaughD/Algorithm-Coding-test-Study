"""
    Code written on Jan 19, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17392번: 우울한 방학
    link: https://www.acmicpc.net/problem/17392
"""
from sys import stdin


promises, holidays = map(int, stdin.readline().split())
gloomy_days = holidays - sum(map(int, stdin.readline().split())) - promises

if gloomy_days > 0:
    gloomy_terms = 1 + promises
    more_gloomy_terms = gloomy_days % gloomy_terms
    less_gloomy_terms = gloomy_terms - more_gloomy_terms
    max_gloomy = gloomy_days // gloomy_terms
    total_gloomy = max_gloomy * (1+max_gloomy) * (1+2*max_gloomy) // 6
    print(
        more_gloomy_terms * (total_gloomy + (max_gloomy+1)**2)
        + (less_gloomy_terms * total_gloomy)
    )
else:
    print(0)
