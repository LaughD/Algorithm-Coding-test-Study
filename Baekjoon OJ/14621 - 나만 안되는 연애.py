"""
    Code written on May 6, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    14621번: 나만 안되는 연애
    link: https://www.acmicpc.net/problem/14621
"""
from sys import stdin


def main():
    num_schools, num_roads = map(int, stdin.readline().split())
    parent_school = [school for school in range(1 + num_schools)]
    school_types = [' '] + stdin.readline().split()
    road_info = []
    for _ in range(num_roads):
        school_a, school_b, length = map(int, stdin.readline().split())
        if school_types[school_a] != school_types[school_b]:
            road_info.append((length, school_a, school_b))
    road_info.sort()
    print(get_path_length(road_info, parent_school, num_schools))


def is_not_connected(parent_school, school_a, school_b):
    return get_parent_school(parent_school, school_a) \
           != get_parent_school(parent_school, school_b)


def get_parent_school(parent_school, school):
    if parent_school[school] != school:
        parent_school[school] = get_parent_school(parent_school, parent_school[school])
    return parent_school[school]


def connect_school(parent_school, school_a, school_b):
    school_a = parent_school[school_a]
    school_b = parent_school[school_b]
    if school_a <= school_b:
        parent_school[school_b] = school_a
    else:
        parent_school[school_a] = school_b


def get_path_length(road_info, parent_school, num_schools):
    path_length = 0
    num_connected_schools = 0
    for length, school_a, school_b in road_info:
        if is_not_connected(parent_school, school_a, school_b):
            connect_school(parent_school, school_a, school_b)
            path_length += length
            num_connected_schools += 1
    return path_length if num_connected_schools + 1 == num_schools else -1


main()
