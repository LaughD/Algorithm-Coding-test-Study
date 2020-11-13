'''
    Code written on Nov 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(2019): 멀쩡한 사각형(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/62048
'''
def gcd(w, h):
    while h:
        w, h = h, w%h
    return w

def solution(w,h):
    return w*h - (w+h) + gcd(w, h)
