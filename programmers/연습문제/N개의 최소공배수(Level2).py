'''
    Code written on Oct 29, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: N개의 최소공배수(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12953
'''
def solution(arr):
    lcm = 1
    for num in arr:
        lcm = (lcm * num)  // gcd(lcm, num)
    return lcm


def gcd(num1, num2):
    while num2:
        num1, num2 = num2, num1%num2
    return num1
