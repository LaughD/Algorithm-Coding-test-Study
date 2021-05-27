"""
    Code written on May 27, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    05639번: 이진 검색 트리
    link: https://www.acmicpc.net/problem/5639
"""
from bisect import bisect_right
from sys import setrecursionlimit, stdin


def main():
    setrecursionlimit(20_000)
    tree = []
    while node := stdin.readline().rstrip():
        tree.append(int(node))
    postorder(tree, 0, len(tree))


def postorder(tree, left, right):
    if left < right:
        bifurcation = bisect_right(tree, tree[left], left + 1, right)
        postorder(tree, left + 1, bifurcation)
        postorder(tree, bifurcation, right)
        print(tree[left])


main()
