'''
    Code written on Oct 12, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 2 x n 타일링(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12900
'''
def solution(n):
    front = back = 1
    for _ in range(n-1):
        front, back = back, (front + back) % 1000000007
    return back
