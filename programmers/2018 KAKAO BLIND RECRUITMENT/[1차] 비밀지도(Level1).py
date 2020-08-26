'''
    Code written on Aug 26, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 비밀지도(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/17681
'''
def solution(n, arr1, arr2):
    sides = map(lambda x: bin(x[0] | x[1])[2:].replace('1', '#'), zip(arr1, arr2))
    sides = map(lambda x: x.replace('0', ' ').rjust(n, ' '), sides)
    return list(sides)