"""
    Code written on Jan 20, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17394번: 핑거 스냅
    link: https://www.acmicpc.net/problem/17394
"""
from collections import deque
from sys import stdin


def bfs():
    queue = deque([num_living])
    checked = {num_living}
    count = 0
    while queue:
        size = len(queue)
        for _ in range(size):
            number = queue.popleft()
            if min_number <= number <= max_number and prime_numbers[number]:
                return f"{count}"
            for next_number in (number//2, number//3, number+1):
                if next_number not in checked:
                    queue.append(next_number)
                    checked.add(next_number)
            if number > 2:
                next_number = number - 1
                if next_number not in checked:
                    queue.append(next_number)
                    checked.add(next_number)
        count += 1


test_cases = int(stdin.readline())

prime_numbers = [False for i in range(100001)]
prime_numbers[2] = True
for i in range(3, 100001, 2):
    for j in range(3, 1+int(i**0.5), 2):
        if not i % j:
            break
    else:
        prime_numbers[i] = True

result = []
for _ in range(test_cases):
    num_living, min_number, max_number = map(int, stdin.readline().split())
    for i in range(min_number, 1+max_number):
        if prime_numbers[i]:
            break
    else:
        result.append("-1")
        continue

    if num_living <= min_number:
        while not prime_numbers[min_number]:
            min_number += 1
        result.append(f"{min_number-num_living}")
        continue

    result.append(bfs())

print("\n".join(result))
