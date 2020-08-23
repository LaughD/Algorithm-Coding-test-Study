'''
    Code written on Aug 23, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 카카오 개발자 겨울 인턴십: 징검다리 건너기(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/64062
'''
def solution(stones, k):
    minimum = 1
    maximum = max(stones)
    while minimum <= maximum:
        count = 0
        middle = (minimum + maximum) // 2
        for stone in stones:
            if stone < middle:
                count += 1
            else:
                count = 0
            if count == k:
                maximum = middle - 1
                break
        else:
            answer = middle
            minimum = middle + 1
    return answer