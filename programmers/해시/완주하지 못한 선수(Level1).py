'''
    Code written on Aug 15, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    해시: 완주하지 못한 선수(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42576
'''
def solution(participant, completion):
    names = {}
    for name in participant:
        names[name] = names.get(name, 0) + 1
    for name in completion:
        names[name] -= 1
        if not names[name]:
            names.pop(name)
    return list(names)[0]