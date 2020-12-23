"""
    Code written on Dec 23, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 숫자의 표현(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12924
"""


def solution(n) -> int:
    num_case: int = 1
    for i in range(1, 1+(n//2)):
        total: int = 0
        for j in range(i, n+1):
            total += j
            if total == n:
                num_case += 1
                break
            elif total > n:
                break
    return num_case
