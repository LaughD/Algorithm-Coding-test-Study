'''
    Code written on Oct 3, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2017 팁스타운: 예상 대진표(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12985
'''
def solution(n,a,b):
    matches = 0
    while a != b:
        a = ((a%2) + a) // 2
        b = ((b%2) + b) // 2
        matches += 1
    return matches
