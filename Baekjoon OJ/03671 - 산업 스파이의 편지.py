"""
    Code written on May 12, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    03671번: 산업 스파이의 편지
    link: https://www.acmicpc.net/problem/3671
"""
from sys import stdin


def main():
    def find_num_primes(number, num_selected, num_papers):
        if number in checked_numbers:
            return
        checked_numbers.add(number)
        if number in all_primes:
            primes.add(number)
        elif number > 9 and is_prime(number):
            all_primes.add(number)
            primes.add(number)
        if num_selected == num_papers:
            return
        num_selected += 1
        for i in range(num_papers):
            if checked_paper[i]:
                continue
            checked_paper[i] = True
            next_number = number * 10 + int(papers[i])
            find_num_primes(next_number, num_selected, num_papers)
            checked_paper[i] = False
        return len(primes)

    all_primes = {2, 3, 5, 7}
    for _ in range(int(stdin.readline())):
        papers = stdin.readline().rstrip()
        primes = set()
        checked_paper = [False] * len(papers)
        checked_numbers = set()
        print(find_num_primes(0, 0, len(papers)))


def is_prime(number):
    if number % 2:
        for divisor in range(3, 1 + int(number ** 0.5), 2):
            if number % divisor:
                continue
            return False
        return True
    return False


main()
