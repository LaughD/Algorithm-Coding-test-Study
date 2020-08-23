'''
    Code written on Aug 23, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 카카오 개발자 겨울 인턴십: 입국심사(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43238
'''
def solution(n, times):
    minimum = min(times)
    maximum = max(times) * (n // len(times) + 1)
    while minimum <= maximum:
        middle = (minimum + maximum) // 2
        passing = 0
        for time in times:
            passing += (middle // time)
            if passing >= n:
                answer = middle
                maximum = middle - 1
                break
        else:
            minimum = middle + 1
    return answer