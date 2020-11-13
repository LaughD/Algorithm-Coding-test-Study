'''
    Code written on Nov 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 같은 숫자는 싫어(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/12906
'''
def solution(arr):
    stack = [arr[0]]
    for num in arr:
        last = stack.pop()
        stack.append(last)
        if num != last:
            stack.append(num)
    return stack
