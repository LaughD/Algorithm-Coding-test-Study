"""
    Code written on Jan 23, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 쿠키 구입(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/49995
"""


def solution(cookie) -> int:
    buyable_cookies: int = 0
    limit_idx: int = len(cookie) - 1
    for i in range(limit_idx):
        left: int = i
        right: int = i + 1
        e_son_cookies: int = cookie[left]  # eldest son's cookies
        s_son_cookies: int = cookie[right]  # second son's cookies
        while True:
            if e_son_cookies == s_son_cookies:
                buyable_cookies = max(buyable_cookies, e_son_cookies)
            if e_son_cookies <= s_son_cookies:
                if not left:
                    break
                left -= 1
                e_son_cookies += cookie[left]
            else:
                if right == limit_idx:
                    break
                right += 1
                s_son_cookies += cookie[right]
    return buyable_cookies
