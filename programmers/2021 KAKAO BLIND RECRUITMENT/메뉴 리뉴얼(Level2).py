"""
    Code written on Apr 25, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2021 KAKAO BLIND RECRUITMENT: 메뉴 리뉴얼(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/72411
"""
from collections import Counter
from itertools import combinations


def solution(orders, course):
    new_courses = []
    for num_foods in course:
        cases = [''.join(sorted(combination))
                 for order in orders
                 for combination in combinations(order, num_foods)]
        num_orders = Counter(cases).most_common()
        for new_course, num_order in num_orders:
            if num_order < 2 or num_order != num_orders[0][1]:
                break
            new_courses.append(new_course)
    new_courses.sort()
    return new_courses
