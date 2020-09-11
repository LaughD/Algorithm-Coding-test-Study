'''
    Code written on Sep 12, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 문자열 압축(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/60057
'''
def solution(s):
    STRLEN = answer = len(s)
    for unit in range(1, 1+STRLEN//2):
        result = []            
        last = s[:unit]
        count = 1
        for i in range(unit, STRLEN+unit, unit):
            this = s[i:i+unit]
            if last == this:
                count += 1
            else:
                if count > 1:
                    result.extend([str(count), last])
                else:
                    result.append(last)
                count = 1
                last = this
        answer = min(len(''.join(result)), answer)
    return answer
