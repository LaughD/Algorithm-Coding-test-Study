'''
    Code written on Aug 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    스택/큐: 주식가격(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42584
'''
from collections import deque
def solution(prices):
    prices = deque(prices)
    answer = []
    while prices:
        head = prices.popleft()
        count = 0
        for this in prices:
            count += 1
            if head > this:
                break
        answer.append(count)
    return answer