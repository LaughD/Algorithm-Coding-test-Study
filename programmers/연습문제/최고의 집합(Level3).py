'''
    Code written on Oct 14, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 최고의 집합(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12938
'''
def solution(n, s):
    if n > s:
        return [-1]
    multi_set = []
    share, rest = s//n, s%n
    for _ in range(n-rest):
        multi_set.append(share)
    for _ in range(rest):
        multi_set.append(share+1)
    return multi_set
