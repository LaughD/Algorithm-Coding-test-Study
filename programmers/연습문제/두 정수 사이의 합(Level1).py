'''
    Code written on Nov 14, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 두 정수 사이의 합(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/12912
'''
'''
    1st solution: arithmetic progression sum formula
'''
def solution(a, b):
    return (abs(b-a)+1)*(a+b)//2


'''
    2nd solution: 단순 더하기
'''
def solution(a, b):
    return sum(range(min(a, b), max(a, b)+1))
