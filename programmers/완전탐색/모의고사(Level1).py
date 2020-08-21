'''
    Code written on Aug 17, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    완전탐색: 모의고사(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42840
'''
def solution(answers):
    abstention1 = [1, 2, 3, 4, 5]
    abstention2 = [2, 1, 2, 3, 2, 4, 2, 5]
    abstention3 = [ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    result = {1 : 0, 2 : 0, 3: 0}
    idx = 0    
    for answer in answers:
        result[1] += (abstention1[idx % 5] == answer)
        result[2] += (abstention2[idx % 8] == answer)
        result[3] += (abstention3[idx % 10] == answer)
        idx += 1
    return list(filter(lambda x: result[x] == max(result.values()), result))