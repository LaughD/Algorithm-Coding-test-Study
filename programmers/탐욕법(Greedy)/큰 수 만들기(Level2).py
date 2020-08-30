'''
    Code written on Aug 30, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 큰 수 만들기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42883
'''
from collections import deque
def solution(number, k):
    storage = deque()
    for num in number:
        while k and storage and storage[0] < num:
            storage.popleft()
            k -= 1
        storage.appendleft(num)
    while k:
        k -= 1
        storage.popleft()
    return ''.join(reversed(storage))