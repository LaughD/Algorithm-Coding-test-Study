'''
    Code written on Sep 18, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [3차] 방금그곡(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17683
'''
from re import sub
def solution(m, musicinfos):
    answer = "(None)"
    longest_time = 0
    m = sub("([A-G][#])", lambda x: x[0].lower()[0], m)
    for musicinfo in musicinfos:
        start, end, title, lyrics = musicinfo.split(',')
        s_hour, s_min = map(int, start.split(':'))
        e_hour, e_min = map(int, end.split(':'))
        play_time = 60 * (e_hour - s_hour) + (e_min - s_min)
        if play_time > longest_time:
            lyrics = sub("([A-G][#])", lambda x: x[0].lower()[0], lyrics)
            lyrics = (lyrics * (1 + play_time // len(lyrics)))[:play_time]
            if m in lyrics:    
                longest_time = play_time
                answer = title
    return answer
