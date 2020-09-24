'''
    Code written on Sep 25, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    깊이/너비 우선 탐색(DFS/BFS): 단어 변환(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43163
'''
from collections import deque

def is_similar(word1, word2):
    count = 0
    for char1, char2 in zip(word1, word2):
        if char1 != char2:
            count += 1
    return True if count == 1 else False

def solution(begin, target, words):
    graph = {begin: filter(lambda word: is_similar(begin, word), words)}    
    for this_word in words:
        graph[this_word] = filter(lambda word: is_similar(this_word, word), words)
    queue = deque()
    queue.append((begin, 0))
    visited = set(begin)            
    while queue:
        this_word, distance = queue.popleft()
        distance += 1
        for word in graph[this_word]:
            if word == target:
                return distance
            elif word not in visited:
                visited.add(word)
                queue.append((word, distance))
    return 0
