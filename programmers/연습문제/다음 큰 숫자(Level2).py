"""
    Code written on Dec 22, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 다음 큰 숫자(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12911
"""


def solution(n) -> int:
    greater: int = n + (n & -n)
    insufficient: int = bin(n).count('1') - bin(greater).count('1')
    for exponential in range(insufficient):
        greater += (2**exponential)
    return greater
