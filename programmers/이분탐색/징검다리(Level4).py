'''
    Code written on Aug 28, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    이분탐색: 징검다리(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/43236
'''
'''
    Edited on Aug 29, 2020
    modified content: 인코딩 방식 수정(한글 주석 깨짐 수정)
        before => ANSI
        after => UTF-8
'''
def solution(distance, rocks, n):
    if len(rocks) == n:
        return distance
    rocks.sort()
    rocks.append(distance)
    left, right = 1, distance
    while left <= right:
        removed = starting = 0
        middle = (left + right) // 2
        minimum = 1000000000
        for rock in rocks:         
            if middle > rock - starting:
                removed += 1
            else:
                minimum = min(minimum, rock-starting)
                starting = rock
            if removed > n:
                right = middle - 1
                break
        else:
            answer = minimum
            left = middle + 1
    return answer

'''
    Code written on Aug 28, 2020
    처음 작성한 코드. 정답처리 되지만, 일부 테스트 케이스를 통과하지 못함.
    해당 테스트 케이스: distance=25, rocks=[6, 12, 18], n=2
'''
# def solution(distance, rocks, n):
#     answer = 0
#     rocks.sort()
#     rocks.append(distance)
#     left, right = 1, distance   
#     while left <= right:
#         removed = starting = 0
#         middle = (left + right) // 2
#         minimum = 1000000000
#         for rock in rocks:
#             if middle <= rock - starting:
#                 minimum = min(minimum, rock-starting)
#                 starting = rock
#             elif rock == distance:
#                  minimum = min(minimum, rock-starting)
#             else:
#                 removed += 1            
#             if removed > n:
#                 right = middle - 1
#                 break
#         else:
#             answer = max(minimum, answer)
#             left = middle + 1
#     return answer