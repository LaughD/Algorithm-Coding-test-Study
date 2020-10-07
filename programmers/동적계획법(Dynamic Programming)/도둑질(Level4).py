'''
    Code written on Oct 7, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    동적계획법(Dynamic Programming): 도둑질(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/42897
'''
'''
    2nd solution: 실행 시간 단축.
'''
def solution(money):
    candidates = []
    first, second = money[0], money[1]

    money = money[2:]			# 첫 번째 집을 털지 않은 경우
    two_prev, prev = 0, second
    for cash in money:
        two_prev, prev = prev, max(two_prev+cash, prev)
    candidates.append(prev)

    money.pop()				# 첫 번째 집을 턴 경우
    two_prev, prev = first, first
    for cash in money:
        two_prev, prev = prev, max(two_prev+cash, prev)
    candidates.append(prev)

    return max(candidates)


'''
    1st solution
'''
'''
def solution(money):
    memo1 = [money[0], money[0]]		# 첫 번째 집을 턴 경우
    for i in range(2, len(money)-1):
        memo1.append(max(memo1[i-2]+money[i], memo1[i-1]))
            
    memo2 = [0, money[1]]			# 첫 번째 집을 털지 않은 경우
    for i in range(2, len(money)):
        memo2.append(max(memo2[i-2]+money[i], memo2[i-1]))
        
    return max(memo1.pop(), memo2.pop())
'''
