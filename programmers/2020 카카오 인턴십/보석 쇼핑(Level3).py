"""
    Code written on Mar 11, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 카카오 인턴십: 보석 쇼핑(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/67258
"""


def solution(gems):
    head = tail = 0
    num_gems = len(gems)
    num_gem_types = len(set(gems))
    min_range_distance = num_gems - 1
    min_range = [1, num_gems]
    gems_dict = {gems[head] : 1}

    while tail < num_gems:
        if len(gems_dict) == num_gem_types:
            if min_range_distance > tail - head:
                min_range_distance = tail - head
                min_range = [head + 1, tail + 1]
            gems_dict[gems[head]] -= 1
            if not gems_dict[gems[head]]:
                gems_dict.pop(gems[head])
            head += 1
        else:
            tail += 1
            if tail == num_gems:
                break
            if gems[tail] not in gems_dict:
                gems_dict[gems[tail]] = 0
            gems_dict[gems[tail]] += 1
    return min_range
