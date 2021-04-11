"""
    Code written on Apr 11, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    월간 코드 챌린지 시즌1: 쿼드압축 후 개수 세기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/68936
"""


def solution(arr):
    return compress_array(arr, 0, 0, len(arr))


def compress_array(arr, r, c, length):
    # r: row, c: column
    value = arr[r][c]
    for row in range(r, r + length):
        for col in range(c, c + length):
            if arr[row][col] != value:
                num_zeros = num_ones = 0
                half_length = length // 2
                for nr, nc in ((r + half_length, c), (r, c + half_length), 
                               (r, c), (r + half_length, c + half_length)):
                    num_elements = compress_array(arr, nr, nc, half_length)
                    num_zeros += num_elements[0]
                    num_ones += num_elements[1]
                return [num_zeros, num_ones]
    return [0, 1] if value else [1, 0]
