"""
    Code written on Mar 12, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 카카오 인턴십: 수식 최대화(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/67257
"""
from itertools import permutations


def solution(expression):
    operators = {char for char in expression if not char.isdigit()}
    num_operators = len(operators)
    max_value = 0
    for operator_list in permutations(operators, num_operators):
        value = abs(int(calc_expression(expression, operator_list, num_operators - 1)))
        if max_value < value:
            max_value = value
    return max_value


def calc_expression(expression, operator_list, operator_priority):
    if not operator_priority:
        return str(eval(expression))
    operator = operator_list[operator_priority]
    operator_priority -= 1
    return str(eval(operator.join(
        calc_expression(exp, operator_list, operator_priority)
        for exp in expression.split(operator)
    )))
