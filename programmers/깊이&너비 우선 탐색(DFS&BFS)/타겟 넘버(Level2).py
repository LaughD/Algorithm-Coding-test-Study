'''
    Code written on Aug 29, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    깊이/너비 우선 탐색(DFS/BFS): 타겟 넘버(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/43165
'''
def solution(numbers, target):
    LENGTH = len(numbers)
    way = 0
    stack = [(0, 0)]
    while stack:
        count, value = stack.pop()
        if count == LENGTH:
            if value == target:
                way += 1
        else:
            stack.append((count+1, value-numbers[count]))
            stack.append((count+1, value+numbers[count]))            
    return way

'''
    Code written on ???, 2020
    Recursion을 활용한 방법. 
    제출 기록은 있으나, 작성일이 기억나지 않음. 2020년 초 무렵으로 추정.
    변수 이름을 고려했을 때, dfs(numbers, target, idx, total)에서 target이 아닌 total에 numbers[idx]를 더하고 빼는 것이 적절해 보임.
'''
# def dfs(numbers, target, idx, total):
#     if len(numbers)-1 == idx:
#         if total == target:
#             return 1
#         else:
#             return 0
#     way = 0
#     idx += 1
#     way += dfs(numbers, target + numbers[idx], idx, total)
#     way += dfs(numbers, target - numbers[idx], idx, total)
#     return way

# def solution(numbers, target):
#     way = 0
#     way += dfs(numbers, target, -1, 0)
#     return way