'''
    Code written on Oct 26, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 줄 서는 방법(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12936
'''
def solution(n, k):
    answer = []
    people = list(range(1, n+1))
    factorial = [1]
    for p in people:
        factorial.append(factorial[p-1]*p)
    while n:
        answer.append(people.pop((k-1)//factorial[n-1]))
        k %= factorial[n-1]
        n -= 1
    return answer
