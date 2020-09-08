'''
    Code written on Sep 8, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 오픈채팅방(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42888
'''
def solution(record):
    statement = {"Enter": "님이 들어왔습니다.", "Leave": "님이 나갔습니다."}
    user = {}
    result = []
    for message in record:
        words = message.split()
        if words[0] != "Change":
            result.append((words[1], words[0]))
        if words[0] != "Leave":
            user[words[1]] = words[2]
    return list(map(lambda x: f"{user[x[0]]}{statement[x[1]]}", result))