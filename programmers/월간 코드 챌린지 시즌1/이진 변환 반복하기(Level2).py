"""
    Code written on Apr 11, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    월간 코드 챌린지 시즌1: 이진 변환 반복하기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/70129
"""


def solution(s):
    num_conversions = num_removed_zeros = 0
    while s != '1':
        num_zeros = s.count('0')
        num_removed_zeros += num_zeros
        num_conversions += 1
        s = bin(len(s) - num_zeros)[2:]
    return num_conversions, num_removed_zeros
