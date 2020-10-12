'''
    Code written on Oct 12, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 3 x n 타일링(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/12902
'''
def solution(n):
    if n % 2:
        return 0
    front = back = 1
    for _ in range(n//2):
        front, back = back, (4*back - front) % 1000000007
    return back
