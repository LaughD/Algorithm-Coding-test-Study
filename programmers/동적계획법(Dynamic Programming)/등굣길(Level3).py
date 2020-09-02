'''
    Code written on Sep 3, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    동적계획법(Dynamic Programming): 등굣길(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42898
'''
def solution(m, n, puddles):
    puddles = {(row, col) for col, row in puddles}
    route = [[1] * m] * n
    for row in range(n):
        for col in range(m):
            if (row+1, col+1) in puddles:
                route[row][col] = 0
            elif not row:
                route[row][col] = route[row][col-1]
            elif not col:
                route[row][col] = route[row-1][col]
            else:
                route[row][col] = route[row-1][col] + route[row][col-1]
    return route[-1][-1] % 1000000007