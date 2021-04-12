"""
    Code written on Apr 12, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    월간 코드 챌린지 시즌1: 내적(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/70128
"""


def solution(a, b):
    return sum(x * y for x, y in zip(a, b))
