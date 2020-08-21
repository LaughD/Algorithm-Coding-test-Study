'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    01158번: 요세푸스 문제
    link: https://www.acmicpc.net/problem/1158
'''
n, k = map(int, input().split())
people = list(range(1, n+1))
josephus = []
pointer = 0

while people:
    pointer= (pointer + k -1) % len(people)
    josephus.append(people.pop(pointer))
josephus = map(str, josephus)
print(f"<{', '.join(josephus)}>")
