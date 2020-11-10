'''
    Code written on Nov 10, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 스킬트리(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/49993
'''
import re

def solution(skill, skill_trees):
    answer = 0
    pattern = re.compile(f"[{skill}]")
    for skill_tree in skill_trees:
        if skill.startswith(''.join(pattern.findall(skill_tree))):
            answer += 1
    return answer
