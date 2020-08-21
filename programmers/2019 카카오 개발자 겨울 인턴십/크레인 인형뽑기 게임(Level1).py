'''
    Code written on Aug 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 카카오 개발자 겨울 인턴십: 크레인 인형뽑기 게임(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/64061
'''
from collections import deque
def solution(board, moves):
    basket, answer, info = [], 0, {idx: deque() for idx in range(len(board))} 
    for line in board:
        for idx, doll in enumerate(line):
            if doll:
                info[idx].append(doll)
    for nline in moves:
        if info[nline-1]:
            doll = info[nline-1].popleft()
            if basket:
                head = basket.pop()
                if head == doll:
                    answer += 2
                else:
                    basket.append(head)
                    basket.append(doll)
            else:
                basket.append(doll)
    return answer