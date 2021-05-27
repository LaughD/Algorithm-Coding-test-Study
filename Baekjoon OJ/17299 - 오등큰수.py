"""
    Code written on May 26, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17299번: 오등큰수
    link: https://www.acmicpc.net/problem/17299
"""


def main():
    sequence_size = int(input())
    sequence = list(map(int, input().split()))
    counter = [0] * 1_000_001
    ngf = ['-1'] * sequence_size
    stack = []

    for number in sequence:
        counter[number] += 1

    for idx in range(sequence_size):
        while stack and counter[sequence[stack[-1]]] < counter[sequence[idx]]:
            ngf[stack.pop()] = f"{sequence[idx]}"
        stack.append(idx)
    print(' '.join(ngf))


main()
