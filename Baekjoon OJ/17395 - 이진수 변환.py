"""
    Code written on Jan 21, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17395번: 이진수 변환
    link: https://www.acmicpc.net/problem/17395
"""
number, n = map(int, input().split())

if bin(number).count('1') < n:
    print(-1)
else:
    sequence = []
    for _ in range(n-1):
        number ^= 1 << (len(bin(number))-3)
        sequence.append(str(number))
    sequence.append('0')
    print(" ".join(sequence))
