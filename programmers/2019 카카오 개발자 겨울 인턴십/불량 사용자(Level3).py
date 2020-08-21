'''
    Code written on Aug 12, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 카카오 개발자 겨울 인턴십: 불량 사용자(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/64064
'''
from re import compile
from itertools import product
def solution(user_id, banned_id):
    targets, cases = [], {}
    for bid in banned_id:
        bid = bid.replace('*', '.')
        targets.append([uid for uid in user_id if compile(bid).fullmatch(uid)])  
    for idx, case in enumerate(map(set, product(*targets))):
        if len(case) == len(banned_id) and case not in cases.values():
            cases[idx] = case
    return len(cases)