'''
    Code written on Oct 19, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 땅따먹기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12913
'''
def solution(land):
    scores = [0] * len(land[0])
    for row in land:
        for idx, score in enumerate(row):
            row[idx] = score + max(scores[0:idx] + scores[idx+1:])
        scores = row
    return max(scores)
