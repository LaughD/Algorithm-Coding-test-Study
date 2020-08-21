'''
    Code written on Aug 14, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 카카오 개발자 겨울 인턴십: 호텔 방 배정(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/64063
'''
def solution(k, room_number):
    answer, status = [], {}
    for room in room_number:
        occupied = [room]
        alternative = room
        while alternative in status:
            alternative = status[alternative]
            occupied.append(alternative)
        for closed in occupied:
            status[closed] = alternative + 1
        answer.append(alternative)
    return answer