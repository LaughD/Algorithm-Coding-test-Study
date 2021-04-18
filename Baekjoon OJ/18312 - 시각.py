"""
    Code written on Apr 18, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18312번: 시각
    link: https://www.acmicpc.net/problem/18312
"""


def main():
    n, k = input().split()
    minute_hand = [f"{m}" if m >= 10 else f"0{m}" for m in range(60)]
    hour_hand = [f"{h}" if h >= 10 else f"0{h}" for h in range(int(n) + 1)]
    count = 0
    for hour in hour_hand:
        for minute in minute_hand:
            for second in minute_hand:
                if k in second or k in minute or k in hour:
                    count += 1
    print(count)


main()
