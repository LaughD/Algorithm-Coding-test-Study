"""
    Code written on Apr 28, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2021 KAKAO BLIND RECRUITMENT: 광고 삽입(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/72414
"""


def solution(play_time, adv_time, logs):
    # cnvt: convert, cum: cumulative
    play_time_sec = cnvt_to_sec(play_time)
    adv_time_sec = cnvt_to_sec(adv_time)
    cum_play_times = get_cum_play_times(play_time_sec, logs)
    return get_best_adv_start_time(play_time_sec, adv_time_sec, cum_play_times)


def cnvt_to_sec(time):
    return 3600 * int(time[:2]) + 60 * int(time[3:5]) + int(time[6:8])


def get_cum_play_times(play_time_sec, logs):
    cum_play_times = [0] * (1 + play_time_sec)
    for start_sec, end_sec in map(lambda x: x.split("-"), logs):
        cum_play_times[cnvt_to_sec(start_sec)] += 1
        cum_play_times[cnvt_to_sec(end_sec)] -= 1
    for time in range(1, play_time_sec):
        cum_play_times[time] += cum_play_times[time - 1]
    for time in range(1, play_time_sec):
        cum_play_times[time] += cum_play_times[time - 1]
    return cum_play_times


def get_best_adv_start_time(play_time_sec, adv_time_sec, cum_play_times):
    max_cum_play_time = cum_play_times[adv_time_sec - 1]
    adv_start_time = 0
    for sec in range(adv_time_sec, play_time_sec):
        cum_play_time = cum_play_times[sec] - cum_play_times[sec - adv_time_sec]
        if cum_play_time > max_cum_play_time:
            max_cum_play_time = cum_play_time
            adv_start_time = sec - adv_time_sec + 1
    return ':'.join((f"{(adv_start_time // 3600):0>2}",
                     f"{(adv_start_time % 3600 // 60):0>2}",
                     f"{(adv_start_time % 60):0>2}"))
