'''
    Code written on Aug 19, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 체육복(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42862
'''
def solution(n, lost, reserve):
    intersection = set(lost) & set(reserve)
    lost = set(lost) - intersection
    reserve = set(reserve) - intersection
    answer = n - len(lost)
    for without in sorted(lost):
        if without-1 in reserve:
            reserve.discard(without-1)
            answer += 1
        elif without+1 in reserve:
            reserve.discard(without+1)
            answer += 1
        if not reserve:
            break
    return answer