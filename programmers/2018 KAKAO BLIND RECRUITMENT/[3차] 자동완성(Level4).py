'''
    Code written on Sep 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [3차] 자동완성(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/17685
'''
def solution(words):
    words.sort()
    autocomplete = {words[0] : 0}
    for front, back in zip(words, words[1:]):
        front_len, back_len = len(front), len(back)
        for idx in range(min(front_len, back_len)):
            if front[idx] != back[idx]:
                if idx+1 > autocomplete[front]:
                    autocomplete[front] = idx + 1
                autocomplete[back] = idx + 1
                break
        else:
            if front_len > back_len:
                if back_len+1 > autocomplete[front]:
                    word_diction[front] = back_len + 1
                autocomplete[back] = back_len
            else:
                autocomplete[front] = front_len
                autocomplete[back] = front_len + 1
    return sum(autocomplete.values())
