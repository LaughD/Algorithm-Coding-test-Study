'''
    Code written on Sep 14, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [3차] 파일명 정렬(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17686
'''
def solution(files):
    file_dict = {}
    for idx, file in enumerate(files):
        file_len = len(file)
        head_end = body_end = 0
        for i in range(file_len):
            if file[i].isdigit():
                head_end = i
                break
        for i in range(head_end, file_len):
            if not file[i].isdigit():
                body_end = i
                break
        else:
            body_end = file_len
        file_dict[(file[:head_end].lower(), int(file[head_end:body_end]), idx)] = file
    return list(map(lambda x: files[x[2]], sorted(file_dict.keys())))
