"""
    Code written on Mar 24, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01765번: 닭싸움 팀 정하기
    link: https://www.acmicpc.net/problem/1765
"""
from sys import stdin


def main():
    num_students = int(stdin.readline())
    team_leader = [student for student in range(num_students + 1)]
    enemy = {}
    for _ in range(int(stdin.readline())):
        relationship, student1, student2 = stdin.readline().split()
        student1 = int(student1)
        student2 = int(student2)
        if relationship == 'F':
            union_team(team_leader, student1, student2)
        elif student1 in enemy:
            union_team(team_leader, enemy[student1], student2)
        elif student2 in enemy:
            union_team(team_leader, student1, enemy[student2])
        else:
            enemy[student1] = student2
            enemy[student2] = student1
    for student in range(1, num_students + 1):
        team_leader[student] = find_leader(team_leader, student)
    print(len(set(team_leader)) - 1)


def find_leader(team_leader, student):
    if team_leader[student] != student:
        team_leader[student] = find_leader(team_leader, team_leader[student])
    return team_leader[student]


def union_team(team_leader, student1, student2):
    leader1 = find_leader(team_leader, student1)
    leader2 = find_leader(team_leader, student2)
    if leader1 < leader2:
        team_leader[leader2] = leader1
    else:
        team_leader[leader1] = leader2


main()
