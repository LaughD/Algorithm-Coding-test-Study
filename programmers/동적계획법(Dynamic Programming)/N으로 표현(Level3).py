'''
    Code written on Oct 10, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    동적계획법(Dynamic Programming): N으로 표현(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42895
'''
def solution(N, number):
    num = 0
    memo = []
    for i in range(8):
        num = num*10 + N
        memo.append(set([num]))
        for j in range(i):
            for a in memo[j]:
                for b in memo[i-j-1]:
                    memo[i].add(a + b)
                    memo[i].add(a - b)
                    memo[i].add(a * b)
                    if b:
                        memo[i].add(a // b)
        if number in memo[i]:
            return i+1
    return -1
