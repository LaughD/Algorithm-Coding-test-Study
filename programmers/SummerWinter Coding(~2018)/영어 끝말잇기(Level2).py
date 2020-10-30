'''
    Code written on Oct 31, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 영어 끝말잇기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12981
'''
def solution(n, words):
    answer = [0, 0]
    word_set = set()
    prev_tail = words[0][0]
    for idx, word in enumerate(words):
        if prev_tail != word[0] or word in word_set:
            answer = [1+idx%n, 1+idx//n]
            break
        word_set.add(word)
        prev_tail = word[-1]
    return answer
