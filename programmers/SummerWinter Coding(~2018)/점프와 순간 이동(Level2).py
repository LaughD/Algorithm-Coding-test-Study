'''
    Code written on Oct 31, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 점프와 순간 이동(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12980
'''
def solution(n):
    return bin(n)[2:].count('1')
