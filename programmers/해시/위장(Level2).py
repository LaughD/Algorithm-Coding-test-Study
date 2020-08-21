'''
    Code written on Aug 16, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    해시: 위장(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42578
'''
from functools import reduce
def solution(clothes):
    closet = {}
    for clothing in clothes:
        closet[clothing[-1]] = closet.get(clothing[-1], 1) + 1
    return reduce(lambda x, y: x * y, closet.values()) - 1