"""
    Code written on Feb 28, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01929번: 소수 구하기
    link: https://www.acmicpc.net/problem/1929
"""


# As of February 28, 2021, it is not an edited code.
def print_primes(start, end):
    is_prime = [True] * (end + 1)
    is_prime[1] = False
    for i in range(2, int(end**0.5) + 1):
        if is_prime[i]:
            for j in range(i * 2, end + 1, i):
                is_prime[j] = False
    is_prime[2] = True
    print(*[i for i in range(start, end + 1) if is_prime[i]], sep="\n")


print_primes(*map(int, input().split()))
