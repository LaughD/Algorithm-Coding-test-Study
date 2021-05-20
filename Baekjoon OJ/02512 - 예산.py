"""
    Code written on May 20, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02512번: 예산
    link: https://www.acmicpc.net/problem/2512
"""


def main():
    num_provinces = int(input())
    budget_list = list(map(int, input().split()))
    whole_budget = int(input())

    infimum = whole_budget // num_provinces
    supremum = max(budget_list)
    while infimum <= supremum:
        median = (infimum + supremum) // 2
        budget_sum = sum(median if median <= budget else budget for budget in budget_list)
        if budget_sum > whole_budget:
            supremum = median - 1
        else:
            infimum = median + 1
    print(supremum)


main()
