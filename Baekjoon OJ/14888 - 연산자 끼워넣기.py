"""
    Code written on Feb 7, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    14888번: 연산자 끼워넣기
    link: https://www.acmicpc.net/problem/14888
"""
n = int(input())
operands = list(map(int, input().split()))


def calculate(total, idx, add, sub, mul, div):
    global max_value
    global min_value
    if idx == n:
        max_value = max(total, max_value)
        min_value = min(total, min_value)
    else:
        if add:
            calculate(total+operands[idx], idx+1, add-1, sub, mul, div)
        if sub:
            calculate(total-operands[idx], idx+1, add, sub-1, mul, div)
        if mul:
            calculate(total*operands[idx], idx+1, add, sub, mul-1, div)
        if div:
            calculate(int(total/operands[idx]), idx+1, add, sub, mul, div-1)


max_value = -1e9
min_value = 1e9
calculate(operands[0], 1, *map(int, input().split()))
print(max_value, min_value, sep="\n")
