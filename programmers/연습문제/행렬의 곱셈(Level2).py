'''
    Code written on Oct 16, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 행렬의 곱셈(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12949
'''
def solution(arr1, arr2):
    return [[sum(map(lambda x: x[0]*x[1], zip(row, col))) for col in zip(*arr2)] for row in arr1]
