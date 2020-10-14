'''
    Code written on Oct 15, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 피보나치 수(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12945
'''
def solution(n):
    front, back = 0, 1
    for _ in range(n-1):
        front, back = back, (front+back) % 1234567
    return back
