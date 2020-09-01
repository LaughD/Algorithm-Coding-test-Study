'''
    Code written on Sep 2, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    동적계획법(Dynamic Programming): 정수 삼각형(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43105
'''
'''
    Second solution: 아래에서 위로 향하는 방법
'''
def solution(triangle):
    for level in range(len(triangle)-1, 0, -1):
        for idx in range(level):
            triangle[level-1][idx] += max(triangle[level][idx:idx+2])
    return triangle[level-1][idx]


'''
    Second solution: 아래에서 위로 향하는 방법(dictionary 사용)
'''
'''
def solution(triangle):
    HEIGHT = len(triangle) - 1
    route_sum = {level : {idx : num for idx, num in enumerate(nums)} for level, nums in enumerate(reversed(triangle))}
    for level in range(HEIGHT):
        for idx in range(HEIGHT-level):
            route_sum[level+1][idx] += max(route_sum[level][idx], route_sum[level][idx+1])
    return route_sum[HEIGHT][0]       
'''


'''
    First solution: 위에서 아래로 향하는 방법. 연산 횟수가 많고 비효율적
'''
'''
def solution(triangle):
    route_sum = {-1 : {0 : 0}}
    for l_idx, level in enumerate(triangle):
        route_sum[l_idx] = {}
        for n_idx, num in enumerate(level):
            if not n_idx:
                route_sum[l_idx][n_idx] = num + route_sum[l_idx-1][n_idx]
            elif l_idx == n_idx:
                route_sum[l_idx][n_idx] = num + route_sum[l_idx-1][n_idx-1]
            else:
                route_sum[l_idx][n_idx] = num + max(route_sum[l_idx-1][n_idx-1], route_sum[l_idx-1][n_idx])
    return max(route_sum[len(triangle)-1].values())
'''