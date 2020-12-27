"""
    Code written on Dec 27, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 지형 편집(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/12984
"""
from collections import Counter
from itertools import chain


def solution(land, P, Q) -> int:
    flattened_land: list = list(chain.from_iterable(land))
    all_cells: int = len(land)**2
    stacked_cells: int = 0
    cost: int = Q * sum(flattened_land)
    min_cost: int = cost
    prev_height: int = 0
        
    for height, cells in sorted(Counter(flattened_land).items()):
        cost += (height - prev_height) \
                * (-Q * (all_cells-stacked_cells) + P * stacked_cells)
        if min_cost < cost:
            break
        stacked_cells += cells
        min_cost = cost
        prev_height = height
    return min_cost
