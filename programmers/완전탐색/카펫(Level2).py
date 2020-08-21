'''
    Code written on Aug 16, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    완전탐색: 카펫(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42842
'''
def solution(brown, yellow):
    blocks = brown + yellow
    for w in range(int(blocks**(1/2))+1, 0, -1):
        if not blocks % w:
            h = int(blocks // w)
            if (w-2) * (h-2) == yellow:
                return [w, h] if w >= h else [h, w]