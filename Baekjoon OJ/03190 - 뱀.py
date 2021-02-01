"""
    Code written on Feb 1, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    03190번: 뱀
    link: https://www.acmicpc.net/problem/3190
"""
from collections import deque
from sys import stdin


size = int(stdin.readline())
# On the board, -1 is a snake and 0 is an apple.
board = [[1] * (1 + size) for _ in range(1 + size)]

for _ in range(int(stdin.readline())):
    row, col = map(int, stdin.readline().split())
    board[row][col] = 0


def is_the_end(snake, turn_time, turn=None) -> bool:
    global time
    global direction
    turn_time = int(turn_time)
    for t in range(1 + time, 1 + turn_time):
        ny = snake[0][0] + dy[direction]
        nx = snake[0][1] + dx[direction]
        if ny < 1 or ny > size or nx < 1 or nx > size or board[ny][nx] == -1:
            time = t
            return True
        # If there is no apple in the position of the snake's head
        if board[ny][nx]:
            py, px = snake.pop()
            board[py][px] = 1
        board[ny][nx] = -1
        snake.appendleft((ny, nx))
    if turn == 'L':
        direction = (direction + 3) % 4
    else:
        direction = (direction + 1) % 4
    time = turn_time
    return False


dy = [0, 1, 0, -1]    # East, South, West, North
dx = [1, 0, -1, 0]    # East, South, West, North
direction = 0         # current direction (0: East ... 3: North)
time = 0
snake = deque([(1, 1)])    # snake[0] is snake's head
board[1][1] = -1
for _ in range(int(stdin.readline())):
    if is_the_end(snake, *stdin.readline().split()):
        print(time)
        break
else:
    is_the_end(snake, time + size)
    print(time)
