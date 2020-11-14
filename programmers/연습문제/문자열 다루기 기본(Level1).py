'''
    Code written on Nov 14, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 문자열 다루기 기본(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/12918
'''
import re

def solution(s):
    return bool(re.fullmatch("[0-9]{4}|[0-9]{6}", s))
