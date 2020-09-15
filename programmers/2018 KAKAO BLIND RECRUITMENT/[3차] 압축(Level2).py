'''
    Code written on Sep 16, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [3차] 압축(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17684
'''
def solution(msg):
    dictionary = {char : num for num, char in enumerate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1)}
    next_num = 27
    word = ""
    answer = []    
    for char in msg:
        new_word = word + char
        if new_word in dictionary:
            word = new_word
        else:
            answer.append(dictionary[word])
            dictionary[new_word] = next_num
            next_num += 1  
            word = char
    answer.append(dictionary[word])
    return answer
