"""
    Code written on Mar 18, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 카카오 인턴십: 경주로 건설(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/67259
"""
# Second solution: Improves code efficiency
from collections import deque


def solution(board):
    new_board = get_expanded_board(board)
    costs = [[1e9] * len(new_board) for _ in range(len(new_board))]

    dy = (0, 0, 1, -1)
    dx = (1, -1, 0, 0)
    rotatable_directions = {0: (0, 2, 3), 1: (1, 2, 3),
                            2: (0, 1, 2), 3: (0, 1, 3)}

    queue = deque([(1, 1, 0, 0), (1, 1, 2, 0)])
    board_size = len(board)
    limit_distance = board_size ** 2
    distance = 1
    while distance <= limit_distance:
        queue_size = len(queue)
        for _ in range(queue_size):
            y, x, direction, cost = queue.popleft()
            for next_direction in rotatable_directions[direction]:
                ny = y + dy[next_direction]
                nx = x + dx[next_direction]
                if not new_board[ny][nx]:
                    if direction == next_direction:
                        new_cost = cost + 100
                    else:
                        new_cost = cost + 600
                    if costs[ny][nx] >= new_cost:
                        costs[ny][nx] = new_cost
                        queue.append((ny, nx, next_direction, new_cost))
        distance += 1
    return costs[board_size][board_size]


def get_expanded_board(board):
    new_board = [[1] * (len(board) + 2)]
    for row in board:
        new_board.append([1] + row + [1])
    new_board.append(new_board[0])
    return new_board


# First solution
"""
from collections import deque


def solution(board):
    new_board = get_expanded_board(board)
    dy = (0, 0, 1, -1)
    dx = (1, -1, 0, 0)
    rotatable_directions = {0: (0, 2, 3), 1: (1, 2, 3),
                            2: (0, 1, 2), 3: (0, 1, 3)}

    past_states = set()
    queue = deque([(1, 1, 0, 0), (1, 1, 2, 0)])
    board_size = len(board)
    limit_distance = board_size ** 2
    distance = 1
    min_cost = 1e9
    while distance <= limit_distance:
        queue_size = len(queue)
        for _ in range(queue_size):
            y, x, direction, num_corners = queue.popleft()
            for next_direction in rotatable_directions[direction]:
                ny = y + dy[next_direction]
                nx = x + dx[next_direction]
                if not new_board[ny][nx]:
                    next_num_corners = num_corners
                    if direction != next_direction:
                        next_num_corners += 1
                    next_state = (ny, nx, next_direction, next_num_corners)
                    if next_state not in past_states:
                        if ny == nx == board_size:
                            cost = distance * 100 + next_num_corners * 500
                            if cost < min_cost:
                                min_cost = cost
                        else:
                            queue.append(next_state)
                        past_states.add(next_state)
        distance += 1
    return min_cost


def get_expanded_board(board):
    new_board = [[1] * (len(board) + 2)]
    for row in board:
        new_board.append([1] + row + [1])
    new_board.append(new_board[0])
    return new_board
"""
