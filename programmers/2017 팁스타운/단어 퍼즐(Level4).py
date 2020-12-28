"""
    Code written on Dec 28, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2017 팁스타운: 단어 퍼즐(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/12983
"""
# 2nd Solution
from collections import defaultdict


def solution(strs, t) -> int:
    t_len: int = len(t)
    over_len: int = t_len + 1
    word_lens: defaultdict = defaultdict(set)
    necessary: list = [over_len for _ in range(over_len)]

    for word in strs:
        word_lens[len(word)].add(word)

    necessary[0] = 0
    for i in range(t_len):
        for length in word_lens:
            extended: int = i + length
            if extended < over_len and t[i:extended] in word_lens[length]:
                necessary[extended] = min(necessary[extended], 1+necessary[i])
    min_necessary: int = necessary.pop()
    return min_necessary if min_necessary != over_len else -1


# 1st Solution
"""
from collections import defaultdict


def solution(strs, t) -> int:
    word_end: defaultdict = defaultdict(list)
    nums_necessary: list = [0]
    over_len: int = len(t) + 1

    for word in strs:
        word_end[word[-1]].append(word)

    for i in range(1, over_len):
        num: int = over_len
        for word in word_end[t[i-1]]:
            word_len: int = len(word)
            if i >= word_len \
                    and nums_necessary[i-word_len] > -1 \
                    and t[i-word_len:i] == word:
                num = min(nums_necessary[i-word_len]+1, num)
        if num == over_len:
            nums_necessary.append(-1)
        else:
            nums_necessary.append(num)
    return nums_necessary.pop()
"""
