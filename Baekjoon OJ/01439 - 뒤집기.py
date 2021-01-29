"""
    Code written on Jan 29, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01439번: 뒤집기
    link: https://www.acmicpc.net/problem/1439
"""
string = input()
count = [0, 0]
prev = 1 ^ int(string[0])

for char in string:
    if prev != int(char):
        count[prev] += 1
        prev = 1 ^ prev
print(min(count))
