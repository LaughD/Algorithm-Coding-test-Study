"""
    Code written on Apr 24, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2021 KAKAO BLIND RECRUITMENT: 합승 택시 요금(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/72413
"""


def solution(n, s, a, b, fares):
    n += 1
    min_fares = [[1e9] * n for _ in range(n)]
    for point in range(1, n):
        min_fares[point][point] = 0

    for point_1, point_2, fare in fares:
        min_fares[point_1][point_2] = min_fares[point_2][point_1] = fare

    for k in range(1, n):
        for i in range(1, n):
            for j in range(1, n):
                if min_fares[i][j] > min_fares[i][k] + min_fares[k][j]:
                    min_fares[i][j] = min_fares[i][k] + min_fares[k][j]

    min_fare = 1e9
    for point in range(1, n):
        if min_fare > min_fares[s][point] + min_fares[point][a] + min_fares[point][b]:
            min_fare = min_fares[s][point] + min_fares[point][a] + min_fares[point][b]
    return min_fare
