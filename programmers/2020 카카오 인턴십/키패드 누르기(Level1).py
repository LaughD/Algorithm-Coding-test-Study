"""
    Code written on Mar 10, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 카카오 인턴십: 키패드 누르기(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/67256
"""


def solution(numbers, hand):
    def move_finger(finger):
        finger[0] = button
        fingers.append(finger[1])

    def get_distance(finger, target):
        return abs(finger[0][0] - target[0]) + abs(finger[0][1] - target[1])

    fingers = []
    left_finger = [(4, 1), 'L']
    right_finger = [(4, 3), 'R']
    buttons = [
        ((number - 1) // 3 + 1, (number - 1) % 3 + 1)
        for number in range(10)
    ]
    buttons[0] = (4, 2)

    for number in numbers:
        button = buttons[number]
        if button[1] == 1:
            move_finger(left_finger)
        elif button[1] == 3:
            move_finger(right_finger)
        else:
            left_distance = get_distance(left_finger, button)
            right_distance = get_distance(right_finger, button)
            if left_distance < right_distance:
                move_finger(left_finger)
            elif left_distance > right_distance:
                move_finger(right_finger)
            elif hand == "left":
                move_finger(left_finger)
            else:
                move_finger(right_finger)
    return ''.join(fingers)
