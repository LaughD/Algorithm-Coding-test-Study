'''
    Code written on Sep 29, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    17478번: 재귀함수가 뭔가요?
    link: https://www.acmicpc.net/problem/17478
'''
def recursion(k, n):
    if k == n:
        print(messages[0] * k + messages[1])
        print(messages[0] * k + messages[6])
        print(messages[0] * k + messages[5])
        return
    print(messages[0] * k + messages[1])
    print(messages[0] * k + messages[2])
    print(messages[0] * k + messages[3])
    print(messages[0] * k + messages[4])
    recursion(k+1, n)
    print(messages[0] * k + messages[5])


messages = {
    0: f'____',
    1: f'"재귀함수가 뭔가요?"',
    2: f'"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.',
    3: f'마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.',
    4: f'그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."',
    5: f'라고 답변하였지.',
    6: f'"재귀함수는 자기 자신을 호출하는 함수라네"'}

n = int(input())
print(f'어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.')
recursion(0, n)
