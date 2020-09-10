'''
    Code written on Sep 10, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 자물쇠와 열쇠(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/60059
'''
def revolve(key):
    return list(zip(*key[::-1]))


def padding(lock, N, key, M):
    size = N + 2 * (M - 1)
    extended = [[0] * size for _ in range(size)]
    for row in range(N):
        for col in range(N):
            extended[M-1+row][M-1+col] = lock[row][col]
    return extended


def insert(extended, key, x, y, M):
    for row in range(M):
        for col in range(M):
            extended[x+row][y+col] += key[row][col]
    

def remove(extended, key, x, y, M):
    for row in range(M):
        for col in range(M):
            extended[x+row][y+col] -= key[row][col]


def is_unlock(extended, N, M):
    for row in range(N):
        for col in range(N):
            if extended[M-1+row][M-1+col] != 1:
                return False
    return True
    

def solution(key, lock):
    N, M = len(lock), len(key)
    if is_unlock(lock, N, 0):
        return True
    extended = padding(lock, N, key, M)
    for _ in range(4):
        for x in range(N+M-1):
            for y in range(N+M-1):
                insert(extended, key, x, y, M)
                if is_unlock(extended, N, M):
                    return True
                remove(extended, key, x, y, M)
        key = revolve(key)
    return False
