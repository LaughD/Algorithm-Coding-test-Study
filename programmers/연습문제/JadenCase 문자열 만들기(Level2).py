'''
    Code written on Oct 18, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: JadenCase 문자열 만들기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12951
'''
def solution(s):
    return ' '.join(map(lambda w: w.capitalize(), s.split(' ')))
