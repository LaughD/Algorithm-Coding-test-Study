"""
    Code written on Apr 12, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    월간 코드 챌린지 시즌1: 두 개 뽑아서 더하기(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/68644
"""
from itertools import combinations as cb


def solution(numbers):
    return sorted(set(sum(two_numbers) for two_numbers in cb(numbers, 2)))
