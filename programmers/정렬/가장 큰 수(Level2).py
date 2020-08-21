'''
    Code written on Aug 18, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    정렬: 가장 큰 수(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42746
'''
def solution(numbers):
    if any(numbers):
        numbers = ''.join(sorted(map(str, numbers), key=lambda x: str(x)*3, reverse=True))
        return numbers
    else:
        return "0"