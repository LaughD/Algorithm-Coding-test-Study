"""
    Code written on May 16, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    07662번: 이중 우선순위 큐
    link: https://www.acmicpc.net/problem/7662
"""
import heapq
from sys import stdin


def main():
    print(*(pop_max_and_min_value() for _ in range(int(stdin.readline()))), sep="\n")


def pop_max_and_min_value():
    max_heap = []
    min_heap = []
    counter = {}
    for _ in range(int(stdin.readline())):
        command, arg = stdin.readline().split()
        arg = int(arg)
        if command == 'I':
            heapq.heappush(max_heap, -arg)
            heapq.heappush(min_heap, arg)
            if arg in counter:
                counter[arg] += 1
            else:
                counter[arg] = 1
        else:
            if counter:
                heap = max_heap if arg == 1 else min_heap
                pop(heap, arg, counter)

    if not counter:
        return "EMPTY"
    elif len(counter) == 1:
        if len(max_heap) >= len(min_heap):
            number = pop(min_heap, -1, counter)
        else:
            number = pop(max_heap, 1, counter)
        return f"{number} {number}"
    else:
        return f"{pop(max_heap, 1, counter)} {pop(min_heap, -1, counter)}"


def pop(heap, arg, counter):
    while heap:
        number = -arg * heapq.heappop(heap)
        if number in counter:
            if counter[number] == 1:
                counter.pop(number)
            else:
                counter[number] -= 1
            return number


main()
