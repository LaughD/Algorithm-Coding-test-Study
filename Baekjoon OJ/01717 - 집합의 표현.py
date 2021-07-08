"""
    Python Version: Python 3.9.4
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01717 - 집합의 표현, https://www.acmicpc.net/problem/1717
"""
from sys import stdin, setrecursionlimit


def main():
    setrecursionlimit(100_000)
    n, m = map(int, stdin.readline().split())
    parent = [number for number in range(n + 1)]
    for _ in range(m):
        operator, number1, number2 = map(int, stdin.readline().split())
        if operator:
            print("YES" if find_parent(parent, number1) == find_parent(parent, number2) 
                  else "NO")
        elif number1 != number2:
            union_parent(parent, number1, number2)


def find_parent(parent, number):
    if parent[number] == number:
        return number
    parent[number] = find_parent(parent, parent[number])
    return parent[number]


def union_parent(parent, number1, number2):
    number1 = find_parent(parent, number1)
    number2 = find_parent(parent, number2)
    if number1 < number2:
        parent[number2] = number1
    else:
        parent[number1] = number2


main()
