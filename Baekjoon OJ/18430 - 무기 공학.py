"""
    Code written on Apr 20, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18430번: 무기 공학
    link: https://www.acmicpc.net/problem/18430
"""


def main():
    def get_max_power(r, c):
        # r: row, c: column
        if r == height:
            return 0
        if c == width:
            return get_max_power(r + 1, 0)
        max_power = get_max_power(r, c + 1)
        if r + 1 < height and c + 1 < width:
            if can_use(r, c + 1, r, c, r + 1, c + 1):
                is_used[r][c + 1] = is_used[r][c] = is_used[r + 1][c + 1] = True
                new_power = 2 * board[r][c + 1] + board[r][c] + board[r + 1][c + 1]
                max_power = max(max_power, new_power + get_max_power(r, c + 1))
                is_used[r][c + 1] = is_used[r][c] = is_used[r + 1][c + 1] = False
            if can_use(r + 1, c + 1, r + 1, c, r, c + 1):
                is_used[r + 1][c + 1] = is_used[r + 1][c] = is_used[r][c + 1] = True
                new_power = 2 * board[r + 1][c + 1] + board[r + 1][c] + board[r][c + 1]
                max_power = max(max_power, new_power + get_max_power(r, c + 1))
                is_used[r + 1][c + 1] = is_used[r + 1][c] = is_used[r][c + 1] = False
            if can_use(r + 1, c, r, c, r + 1, c + 1):
                is_used[r + 1][c] = is_used[r][c] = is_used[r + 1][c + 1] = True
                new_power = 2 * board[r + 1][c] + board[r][c] + board[r + 1][c + 1]
                max_power = max(max_power, new_power + get_max_power(r, c + 1))
                is_used[r + 1][c] = is_used[r][c] = is_used[r + 1][c + 1] = False
            if can_use(r, c, r, c + 1, r + 1, c):
                is_used[r][c] = is_used[r][c + 1] = is_used[r + 1][c] = True
                new_power = 2 * board[r][c] + board[r][c + 1] + board[r + 1][c]
                max_power = max(max_power, new_power + get_max_power(r, c + 1))
                is_used[r][c] = is_used[r][c + 1] = is_used[r + 1][c] = False
        return max_power

    def can_use(r1, c1, r2, c2, r3, c3):
        if is_used[r1][c1] or is_used[r2][c2] or is_used[r3][c3]:
            return False
        return True

    height, width = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(height)]
    is_used = [[False] * width for _ in range(height)]
    print(get_max_power(0, 0))


main()
