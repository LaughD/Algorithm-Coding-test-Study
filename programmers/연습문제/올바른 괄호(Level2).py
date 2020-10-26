'''
    Code written on Oct 27, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 올바른 괄호(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12909
'''
def solution(s):
    sign = 0
    for bracket in s:
        if bracket == '(':
            sign += 1
        else:
            sign -= 1
        if sign < 0:
            break
    return sign == 0
