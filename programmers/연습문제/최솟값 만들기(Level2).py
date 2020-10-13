'''
    Code written on Oct 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 최솟값 만들기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12941
'''
def solution(A,B):
    return sum([a*b for a, b in zip(sorted(A), sorted(B, reverse=True))])
