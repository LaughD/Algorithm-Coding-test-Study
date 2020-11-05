'''
    Code written on Nov 5, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 기지국 설치(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12979
'''
def solution(n, stations, w):
    RANGE = 2*w + 1
    range_head = 1
    answer = 0
    for station in stations:
        l_out_range, r_out_range = station-w-1, station+w+1
        if range_head <= l_out_range:
            area = l_out_range - range_head + 1
            answer += (area//RANGE + (area%RANGE != 0))
        range_head = r_out_range
    if range_head <= n:
        area = n - range_head + 1
        answer += (area//RANGE + (area%RANGE != 0))        
    return answer
