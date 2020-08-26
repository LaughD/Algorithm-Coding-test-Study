'''
    Code written on Aug 26, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 뉴스 클러스터링(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17677
'''
from collections import Counter
def make_set(string, length):
    storage = []
    for i in range(length-1):
        this = string[i] + string[i+1]
        if this.isalpha():
            storage.append(this)
    return Counter(storage), len(storage)

def solution(str1, str2):
    set1, set1_length = make_set(str1.lower(), len(str1))
    set2, set2_length = make_set(str2.lower(), len(str2))
    if not set1_length and not set2_length:
        return 65536
    intersection = len(list((set1 & set2).elements()))
    union = set1_length + set2_length - intersection
    return int(65536 * intersection / union)