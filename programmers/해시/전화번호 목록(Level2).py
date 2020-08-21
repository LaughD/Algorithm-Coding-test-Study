'''
    Code written on Aug 15, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    해시: 전화번호 목록(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42577
'''
from collections import deque
def solution(phone_book):
    phone_book.sort()
    for i, j in zip(phone_book, phone_book[1:]):
        if j.startswith(i):
            return False
    return True