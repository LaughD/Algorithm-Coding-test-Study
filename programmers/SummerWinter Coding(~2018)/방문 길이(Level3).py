'''
    Code written on Nov 3, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 방문 길이(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/49994
'''
def solution(dirs):
    command = {'U': (0, 1), 'D': (0, -1), 'R': (1, 0), 'L': (-1, 0)}
    x_coor, y_coor = 0, 0
    ways = set()
    for direction in dirs:
        movement_x, movement_y = command[direction]
        next_x_coor = x_coor + movement_x
        next_y_coor = y_coor + movement_y
        if (-5 <= next_x_coor <= 5 and -5 <= next_y_coor <= 5):
            ways.add((x_coor, y_coor, next_x_coor, next_y_coor))
            ways.add((next_x_coor, next_y_coor, x_coor, y_coor))
            x_coor, y_coor = next_x_coor, next_y_coor
    return len(ways)//2
