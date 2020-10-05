'''
    Code written on Oct 5, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 나누어 떨어지는 숫자 배열(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/12910
'''
def solution(arr, divisor):
    filtered = sorted(filter(lambda num: not (num % divisor), arr))
    return filtered if filtered else [-1]
