'''
    Code written on Nov 9, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 하노이의 탑(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12946
'''
def hanoi(n, starting, waypoint, dest, answer):
    if n == 1:
        answer.append([starting, dest])
        return
    hanoi(n-1, starting, dest, waypoint, answer)
    answer.append([starting, dest])
    hanoi(n-1, waypoint, starting, dest, answer)

def solution(n):
    answer = []
    hanoi(n, 1, 2, 3, answer)
    return answer
