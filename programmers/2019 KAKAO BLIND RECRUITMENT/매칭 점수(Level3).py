"""
    Code written on Dec 25, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 매칭 점수(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42893
"""


import re
from collections import defaultdict


def solution(word, pages) -> int:
    urls: list = []
    matching_scores: defaultdict = defaultdict(float)
    highest_score: float = 0
    highest_score_idx: int = 0

    for page in pages:
        url = re.search(f"<meta property=\"og:url\" content=\"(\S+)\"", 
                        page).group(1)
        urls.append(url)

        body = re.search(f"<body>(.+)<\/body>", page, re.DOTALL).group(1)
        base_score: float = 0.0
        strings = re.findall(f"[a-zA-Z]+", body)
        for string in strings:
            if re.match(f"(^{word}$)", string, re.I):
                base_score += 1.0
        matching_scores[url] += base_score

        links = re.findall(f"<a href=\"(\S+)\"", body)
        num_links = len(links)
        for link in links:
            matching_scores[link] += (base_score / num_links)

    for idx, url in enumerate(urls):
        if highest_score < matching_scores[url]:
            highest_score = matching_scores[url]
            highest_score_idx = idx
    return highest_score_idx
