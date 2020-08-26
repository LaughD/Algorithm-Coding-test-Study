'''
    Code written on Aug 26, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 다트 게임(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/17682
'''
def solution(dartResult):
    domain = {'S' : 1, 'D' : 2, 'T' : 3}
    before = now = total = 0
    num = ''
    for dart in dartResult:
        if dart.isdigit():
            num += dart
        elif dart in domain:
            total += before
            before = now
            now = int(num) ** domain[dart]
            num = ''
        elif dart == '#':
            now *= -1
        else:
            before *= 2
            now *= 2
    total += before + now
    return total