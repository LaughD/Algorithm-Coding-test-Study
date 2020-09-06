'''
    Code written on Sep 7, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    그래프: 순위(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/49191
'''
from collections import defaultdict
def solution(n, results):
    if n == 1:
        return 1
    victorious = defaultdict(set)   # key's victorious target
    defeated = defaultdict(set)     # key's defeated target
    for winner, loser in results:
        victorious[winner].add(loser)
        defeated[loser].add(winner)
    for player in range(1, n+1):
        for stronger in defeated[player]:
            victorious[stronger].update(victorious[player])
        for weaker in victorious[player]:
            defeated[weaker].update(defeated[player])
    answer = 0
    for player in range(1, n+1):
        if len(victorious[player]) + len(defeated[player]) == n-1:
            answer += 1
    return answer