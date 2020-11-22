'''
    Code written on Nov 22, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 문자열 내 p와 y의 개수(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/12916
'''
import re

def solution(s):
    return len(re.findall('p', s, re.I)) == len(re.findall('y', s, re.I))
