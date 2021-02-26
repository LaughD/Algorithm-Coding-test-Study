"""
    Code written on Feb 26, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 숫자 블록(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/12923
"""


def solution(begin, end):
    array = [get_lpd(number) for number in range(begin, end + 1)]
    if begin == 1:
        array[0] = 0
    return array


def get_lpd(number):    # 'lpd' means the largest proper divisor
    for d in range(2, int(number**0.5) + 1):
        if (not number % d) and (number // d <= 10000000):
            return number // d
    return 1
