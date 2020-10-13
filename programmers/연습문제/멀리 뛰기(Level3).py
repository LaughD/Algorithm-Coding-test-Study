'''
    Code written on Oct 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 멀리 뛰기(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12914
'''
def solution(n):
    front = back = 1
    for _ in range(n-1):
        front, back = back, (back+front) % 1234567
    return back
