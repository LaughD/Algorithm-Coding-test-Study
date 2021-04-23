"""
    Code written on Apr 23, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2021 KAKAO BLIND RECRUITMENT: 신규 아이디 추천(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/72410
"""
import re


def solution(new_id):
    new_id = new_id.lower()
    new_id = re.sub("[^0-9a-z\-_.]", '', new_id)
    new_id = re.sub("\.+", '.', new_id)
    new_id = re.sub("^\.|\.$", '', new_id)
    if not new_id: 
        new_id = 'a'
    new_id_length = len(new_id)
    if new_id_length >= 16:
        if new_id[14] == '.':
            new_id = new_id[:14]
        else:
            new_id = new_id[:15]
    if new_id_length <= 2: 
        new_id = new_id.ljust(3, new_id[-1])
    return new_id
