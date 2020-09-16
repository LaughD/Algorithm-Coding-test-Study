'''
    Code written on Sep 17, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 후보키(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42890
'''
from itertools import combinations
def solution(relation):
    DEGREE = len(relation[0])
    candidate_keys = []
    for num in range(1, DEGREE):
        for chosen_cols in combinations(range(DEGREE), num):
            key = set(chosen_cols)                  # check minimality
            for candidate_key in candidate_keys:
                if candidate_key.issubset(key):
                    break
            else:
                identifiers = set()                 # check uniqueness
                for tuple_ in relation:
                    identifier = tuple(map(lambda x: tuple_[x], chosen_cols))
                    if identifier in identifiers:
                        break
                    identifiers.add(identifier)
                else:
                    candidate_keys.append(key)
    return len(candidate_keys) + 1 * (not candidate_keys)
