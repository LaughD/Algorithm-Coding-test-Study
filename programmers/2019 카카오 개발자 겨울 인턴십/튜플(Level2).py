'''
    Code written on Aug 12, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 카카오 개발자 겨울 인턴십: 튜플(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/64065
'''
def solution(s):
    answer = []
    s = sorted(s[1:-2].split("},"), key=len)
    answer = [int(s[0][1:])]
    s = [set(map(int, part[1:].split(','))) for part in s]
    for p1, p2 in zip(s[1:], s):
        answer.append((p1-p2).pop())
    return answer