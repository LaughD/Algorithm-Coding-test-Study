"""
    Code written on Dec 30, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    02108번: 통계학
    link: https://www.acmicpc.net/problem/2108
"""
from collections import Counter
from sys import stdin


count, *nums = map(int, stdin.readlines())
nums.sort()
counter = Counter(nums)

avg = round(sum(nums)/count)
mid = nums[count//2]
if count != 1:
    first_most, second_most = counter.most_common(2)
    most = first_most[0] if first_most[1] != second_most[1] else second_most[0]
else:
    most = counter.most_common(1)[0][0]
scope = nums.pop()-nums[0] if count != 1 else 0

print(f"{avg}\n{mid}\n{most}\n{scope}")
