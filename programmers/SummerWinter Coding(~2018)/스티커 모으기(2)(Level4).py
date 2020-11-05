'''
    Code written on Nov 6, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 스티커 모으기(2)(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/12971
'''
'''
    Edited on Nov 6, 2020
    modified content: 변수 이름 변경
        before => tail_choice_case
        after => head_no_choice_case
'''
def solution(sticker):
    if len(sticker) == 1:
        return sticker.pop()

    temp, sticker[1] = sticker[1], 0
    prev = now = 0
    for num in sticker:
        prev, now = now, max(prev+num, now)
    head_choice_case = prev

    sticker[0], sticker[1] = 0, temp
    prev = now = 0
    for num in sticker:
        prev, now = now, max(prev+num, now)
    head_no_choice_case = now

    return max(head_choice_case, head_no_choice_case)
