"""
    Code written on Jan 12, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    찾아라 프로그래밍 마에스터: 폰켓몬(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/1845
"""


def solution(nums) -> int:
    # return min(len(nums)//2, len(set(nums)))
    species: set = set(nums)
    num_selection: int = len(nums) // 2
    num_species: int = len(species)
    return num_species if num_species <= num_selection else num_selection
