'''
    Code written on Sep 11, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 괄호 변환(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/60058
'''
from collections import deque

def solution(p):
    p = deque(p)
    return ''.join(conversion(p))


def conversion(p):
    if not p:
        return p
    u, v, proper = detach(p)
    if proper:
        return u + conversion(v)
    else:
        new_v = deque(['('])
        new_v.extend(conversion(v))
        new_v.append(')')
        u.popleft()
        u.pop()        
        new_v.extend(reverse(u))
        return new_v


def detach(p):
    proper = True
    count = 0
    u = deque()
    while p:
        char = p.popleft()
        u.append(char)
        if char == '(':
            count += 1
        else:
            count -= 1
        if count < 0:
            proper = False
        elif not count:
            break
    return u, p, proper


def reverse(u):
    new_u = deque()
    for char in u:
        if char == '(':
            new_u.append(')')
        else:
            new_u.append('(')
    return new_u
