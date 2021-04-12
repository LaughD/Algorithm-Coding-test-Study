"""
    Code written on Apr 12, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    월간 코드 챌린지 시즌1: 3진법 뒤집기(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/68935
"""


def solution(n):
    ternary_number = []
    while n:
        n, remainder = divmod(n, 3)
        ternary_number.append(str(remainder))
    return int(''.join(ternary_number), 3)
