"""
    Code written on Jan 25, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 블록 이동하기(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/60063
"""
from collections import deque


def move_block(board, passed, ul, dr, state):
    # ul: up or left, dr: down or right, state: {0: horizontal, 1: vertical}
    for r, c in ((-1, 0), (1, 0), (0, -1), (0, 1)):
        if (not board[ul[0]+r][ul[1]+c]) and (not board[dr[0]+r][dr[1]+c]):
            next_loc = ((ul[0]+r, ul[1]+c), (dr[0]+r, dr[1]+c), state)
            if next_loc not in passed:
                yield next_loc
    if state:
        for c in (-1, 1):
            if (not board[ul[0]][ul[1]+c]) and (not board[dr[0]][dr[1]+c]):
                next_loc = ((ul[0], ul[1]+c), ul, 0) if c == -1 \
                    else (ul, (ul[0], ul[1]+c), 0)
                if next_loc not in passed:
                    yield next_loc
                next_loc = ((dr[0], dr[1]+c), dr, 0) if c == -1 \
                    else (dr, (dr[0], dr[1]+c), 0)
                if next_loc not in passed:
                    yield next_loc
    else:
        for r in (-1, 1):
            if (not board[ul[0]+r][ul[1]]) and (not board[dr[0]+r][dr[1]]):
                next_loc = ((dr[0]+r, dr[1]), dr, 1) if r == -1 \
                    else (dr, (dr[0]+r, dr[1]), 1)
                if next_loc not in passed:
                    yield next_loc
                next_loc = ((ul[0]+r, ul[1]), ul, 1) if r == -1 \
                    else (ul, (ul[0]+r, ul[1]), 1)
                if next_loc not in passed:
                    yield next_loc


def solution(board):
    width: int = len(board)
    count: int = 1
    destination: tuple = (width, width)
    passed: set = {((1, 1), (1, 2), 0)}
    queue: deque = deque([((1, 1), (1, 2), 0)])

    board.insert(0, [1] * (2 + width))
    for i in range(1, len(board)):
        board[i].insert(0, 1)
        board[i].append(1)
    board.append(board[0])

    while queue:
        for _ in range(len(queue)):
            for next_loc in move_block(board, passed, *queue.popleft()):
                if next_loc[1] == destination:
                    return count
                queue.append(next_loc)
                passed.add(next_loc)
        count += 1
    return 0
