'''
    Code written on Sep 25, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    깊이/너비 우선 탐색(DFS/BFS): 단어 변환(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43163
'''
'''
    Edited on Sep 25, 2020
    modified content: solution 추가
'''
'''
    2nd solution: yield & Generator를 활용한 방법. 프로그래머스 다른 사람의 풀이를 참고하였음.
    Reference: https://programmers.co.kr/learn/courses/30/lessons/43163/solution_groups?language=python3
'''
from collections import deque

def find_neighbor(this_word, words):
    for word in words:
        count = 0
        for char1, char2 in zip(this_word, word):
            if char1 != char2:
                count += 1
        if count == 1:
            yield word
            
def solution(begin, target, words):
    distance = {begin: 0}
    queue = deque([begin])
    while queue:
        this_word = queue.popleft()
        for word in find_neighbor(this_word, words):
            if word == target:
                return distance[this_word] + 1
            elif word not in distance:
                distance[word] = distance[this_word] + 1
                queue.append(word)
    return 0


'''
    1st solution: 탐색 이전에 graph(각 node의 이웃 집합)를 설정한 방식. 비효율적.
'''
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
'''
