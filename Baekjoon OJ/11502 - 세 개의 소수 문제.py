"""
    Code written on Mar 20, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    11502번: 세 개의 소수 문제
    link: https://www.acmicpc.net/problem/11502
"""
from sys import stdin


def main():
    numbers = [int(stdin.readline()) for _ in range(int(stdin.readline()))]
    max_number = max(numbers)
    is_prime = [True] * (max_number + 1)
    primes = get_primes(is_prime, max_number)
    print("\n".join(
        get_combination(primes, is_prime, number) for number in numbers)
    )


def get_primes(is_prime, max_number):
    for number in range(2, int(max_number**0.5) + 1):
        if is_prime[number]:
            for multiple in range(number * 2, max_number + 1, number):
                is_prime[multiple] = False
    return [2] + [number for number in range(3, max_number + 1, 2)
                  if is_prime[number]]


def get_combination(primes, is_prime, number):
    for number1 in primes:
        if number1 >= number:
            break
        if is_prime[number1]:
            for number2 in primes:
                if number2 >= number:
                    break
                if is_prime[number2]:
                    number3 = number - number1 - number2
                    if number3 >= 3 and is_prime[number3]:
                        return f"{number1} {number2} {number3}"
    return '0'


main()
