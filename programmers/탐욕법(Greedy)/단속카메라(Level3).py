'''
    Code written on Sep 1, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 단속카메라(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42884
'''
def solution(routes):
    camera = 1
    base_point = routes[0][-1]
    for route in sorted(routes, key=lambda x: (x[0], x[-1])):
        enter, exit = route
        if base_point >= enter:
            base_point = min(base_point, exit)
        else:
            base_point = exit
            camera += 1
    return camera