'''
    Code written on Nov 8, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 예산(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/12982
'''
def solution(d, budget):
    answer = 0
    for price in sorted(d):
        budget -= price
        if budget < 0:
            break
        answer += 1
    return answer
