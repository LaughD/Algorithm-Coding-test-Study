"""
    Code written on Jan 27, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: N-Queen(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12952
"""


def solution(n) -> int:
    width = n

    def n_queen(placement) -> int:
        nonlocal width
        col = len(placement)
        if col == width:
            return 1
        case = 0
        for row in range(width):
            for c in range(col):
                if (placement[c] == row) or \
                        (col - c == abs(placement[c] - row)):
                    break
            else:
                placement.append(row)
                case += n_queen(placement)
                placement.pop()
        return case

    return n_queen([])
