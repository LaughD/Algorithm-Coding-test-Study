'''
    Code written on Aug 16, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    완전탐색: 소수 찾기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42839
'''
from itertools import permutations
def solution(numbers):
    answer = 0
    nums = set()
    for digit in range(1, len(numbers)+1):
        for number in permutations(numbers, digit):
            number = ''.join(number)
            nums.add(int(number))
    nums.discard(0)
    nums.discard(1)
    if 2 in nums:
        nums.remove(2)
        answer += 1
    for num in list(filter(lambda x: x % 2, nums)):
        for share in range(3, int(num**(1/2))+1, 2):
            if not num % share:
                break
        else:
            answer += 1
    return answer