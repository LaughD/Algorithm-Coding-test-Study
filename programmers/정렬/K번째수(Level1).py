'''
    Code written on Aug 17, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    정렬: K번째수(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42748
'''
def solution(array, commands):
    return [sorted(array[si-1:ei])[n-1] for si, ei, n in commands]