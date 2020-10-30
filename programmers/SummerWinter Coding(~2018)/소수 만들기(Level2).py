'''
    Code written on Oct 30, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 소수 만들기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12977
'''
from itertools import combinations

def solution(nums):
    answer = 0
    for case in combinations(nums, 3):
        case_sum = sum(case)            # case_sum >= 6
        if case_sum % 2:
            for div_num in range(3, int(case_sum**0.5)+1, 2):
                if not case_sum % div_num:
                    break
            else:
                answer += 1
    return answer
