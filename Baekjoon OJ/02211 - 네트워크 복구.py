"""
    Code written on Mar 9, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02211번: 네트워크 복구
    link: https://www.acmicpc.net/problem/2211
"""
import heapq
from sys import stdin


def main():
    n, m = map(int, stdin.readline().split())
    network = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b, c = map(int, stdin.readline().split())
        network[a].append([c, b])
        network[b].append([c, a])

    times = [1e9] * (n + 1)
    circuits = [0] * (n + 1)

    heap = [(0, 1)]
    while heap:
        time, computer = heapq.heappop(heap)
        if times[computer] >= time:
            for additional_time, neighboring_computer in network[computer]:
                new_time = additional_time + time
                if new_time < times[neighboring_computer]:
                    circuits[neighboring_computer] = computer
                    times[neighboring_computer] = new_time
                    heapq.heappush(heap, (new_time, neighboring_computer))

    result = '\n'.join(
        f'{str(circuits[computer])} {str(computer)}'
        for computer in range(2, n + 1)
    )
    print(f"{n - 1}\n{result}")


main()
