'''
    Code written on Nov 4, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 숫자 게임(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12987
'''
def solution(A, B):
    A.sort()
    B.sort()
    score = 0
    while A:
        b = B.pop()
        if A.pop() < b:
            score += 1
        else:
            B.append(b)
    return score
