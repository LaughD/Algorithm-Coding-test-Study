'''
    Code written on Aug 20, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 구명보트(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42885
'''
from collections import deque
def solution(people, limit):
    people = deque(sorted(people))
    boat = 0
    while len(people) > 1:
        people.rotate()
        tail = people.popleft()
        if people[0] + tail <= limit:
            people.popleft()
        boat += 1
    return boat + 1 * bool(people)