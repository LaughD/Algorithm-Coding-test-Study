"""
    Code written on Jan 6, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    05430번: AC
    link: https://www.acmicpc.net/problem/5430
"""
from sys import stdin


results = []
for _ in range(int(stdin.readline())):
    command = stdin.readline().rstrip()
    length = int(stdin.readline())
    array = stdin.readline().rstrip()

    array = array[1:-1].split(',')
    left = right = 0
    is_reversed = False
    for c in command:
        if c == 'R':
            is_reversed = not is_reversed
        else:
            if is_reversed:
                right += 1
            else:
                left += 1
    right = length - right
    if left > right:
        results.append("error")
    else:
        array = array[left:right]
        if is_reversed:
            results.append('[' + ','.join(array[::-1]) + ']')
        else:
            results.append('[' + ','.join(array) + ']')

print('\n'.join(results))
