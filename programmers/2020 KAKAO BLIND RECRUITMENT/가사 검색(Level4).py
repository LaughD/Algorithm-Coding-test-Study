'''
    Code written on Sep 10, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 가사 검색(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/60060
'''
'''
    두 번째 코드(새로 알게 된 방법: bisect 활용)
'''
from collections import defaultdict
from bisect import bisect_left, bisect_right
def solution(words, queries):
    lyrics = defaultdict(list)
    inverted = defaultdict(list)    
    for word in words:
        strlen = len(word)
        lyrics[strlen].append(word)
        inverted[strlen].append(word[::-1])
    for storage in lyrics.values():
        storage.sort()
    for storage in inverted.values():
        storage.sort()
    precedent = {}
    answer = []    
    for query in queries:
        if query in precedent:
            answer.append(precedent[query])
        else:
            strlen = len(query)
            if query[0] == '?':
                q = query[::-1]
                word_list = inverted[strlen]
            else:
                q = query
                word_list = lyrics[strlen]
            start = q.replace('?', 'a')
            end = q.replace('?', 'z')
            result = bisect_right(word_list, end) - bisect_right(word_list, start)
            precedent[query] = result
            answer.append(result)
    return answer


'''
    첫 번째 코드
'''
'''
from collections import defaultdict
def find_idx(word, word_list):
    left = 0
    right = len(word_list) - 1
    while left <= right:
        middle = (left + right) // 2
        if word <= word_list[middle]:
            right = middle - 1
        else:
            left = middle + 1
    return right

def solution(words, queries):
    lyrics = defaultdict(list)
    inverted = defaultdict(list)    
    for word in words:
        strlen = len(word)
        lyrics[strlen].append(word)
        inverted[strlen].append(word[::-1])
    for storage in lyrics.values():
        storage.sort()
    for storage in inverted.values():
        storage.sort()
    precedent = {}
    answer = []    
    for query in queries:
        if query in precedent:
            answer.append(precedent[query])
        else:
            strlen = len(query)
            if query[0] == '?':
                q = query[::-1]
                word_list = inverted[strlen]
            else:
                q = query
                word_list = lyrics[strlen]
            start = q.replace('?', 'a')
            end = q.replace('?', 'z')
            result = find_idx(end, word_list) - find_idx(start, word_list)
            precedent[query] = result
            answer.append(result)
    return answer
'''