'''
    Code written on Sep 28, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    06603번: 로또
    link: https://www.acmicpc.net/problem/6603
'''
'''
    2nd solution: recursion 사용
'''
from sys import stdin

def combinations(start_idx, selected, nums, len_nums):
    if len(selected) == 6:
        print(' '.join(selected))
        return
    for idx in range(start_idx+1, len_nums):
        selected.append(nums[idx])
        combinations(idx, selected, nums, len_nums)
        selected.pop()        

while True:
    nums = stdin.readline().split()
    if nums[0] == '0':
        break
    nums = nums[1:]
    for start_idx in range(len(nums)-5):
        combinations(start_idx, [nums[start_idx]], nums, len(nums))
    print()


'''
    1st solution: itertools.combinations 사용
'''
'''
from sys import stdin
from itertools import combinations

while True:
    nums = stdin.readline().split()
    if nums[0] == '0':
        break
    for case in combinations(nums[1:], 6):
        print(' '.join(case))
    print()
'''
