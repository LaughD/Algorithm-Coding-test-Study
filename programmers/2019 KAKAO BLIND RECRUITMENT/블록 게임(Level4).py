"""
    Code written on Mar 5, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 블록 게임(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/42894
"""
def solution(board):
    def get_removed():
        removed = 0
        for r in range(size):
            for c in range(size):
                if r < size - 1 and c < size - 2 and can_remove(r, c, 2, 3):
                    remove(r, c, 2, 3)
                    removed += 1
                elif r < size - 2 and c < size - 1 and can_remove(r, c, 3, 2):
                    remove(r, c, 3, 2)
                    removed += 1
        return removed

    def can_remove(row, col, height, width):
        black_blocks = 0
        block = -1
        for r in range(row, row + height):
            for c in range(col, col + width):
                if board[r][c]:
                    if (block != -1) and (block != board[r][c]):
                        return False
                    block = board[r][c]
                else:
                    if is_no_opened(r, c):
                        return False
                    black_blocks += 1
                    if black_blocks > 2:
                        return False
        return True

    def is_no_opened(row, col):
        for r in range(row):
            if board[r][col]:
                return True
        return False

    def remove(row, col, height, width):
        for r in range(row, row + height):
            for c in range(col, col + width):
                board[r][c] = 0

    size = len(board)
    total_removed = 0
    while True:
        removed = get_removed()
        if not removed:
            break
        total_removed += removed
    return total_removed
