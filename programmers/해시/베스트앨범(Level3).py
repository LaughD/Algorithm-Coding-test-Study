'''
    Code written on Aug 17, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    해시: 베스트앨범(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42579
'''
def solution(genres, plays):
    answer, chart = [], {}
    idx = 0
    for genre, play in zip(genres, plays):
        if genre in chart:
            chart[genre][0][idx] = play
            chart[genre][-1] += play
        else:
            chart[genre] = [{idx : play}, play]
        idx += 1
    for genre in sorted(chart, key=lambda x: chart[x][-1], reverse=True):
        idx = 0
        for unique in sorted(chart[genre][0], key=lambda x: chart[genre][0][x], reverse=True):
            answer.append(unique)
            idx += 1
            if idx == 2:
                break
    return answer