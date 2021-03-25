"""
    Code written on Mar 25, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01244번: 스위치 켜고 끄기
    link: https://www.acmicpc.net/problem/1244
"""
from sys import stdin


def main():
    num_switches = int(stdin.readline())
    switches = [-1] + list(map(int, stdin.readline().split()))
    for _ in range(int(stdin.readline())):
        gender, switch = map(int, stdin.readline().split())
        if gender == 1:
            for switch_ in range(switch, num_switches + 1, switch):
                switches[switch_] ^= 1
        else:
            switches[switch] ^= 1
            left, right = switch - 1, switch + 1
            while 1 <= left and right <= num_switches:
                if switches[left] == switches[right]:
                    switches[left] ^= 1
                    switches[right] ^= 1
                    left -= 1
                    right += 1
                else:
                    break
                    
    for i in range(1, num_switches + 1, 20):
        print(*switches[i:i+20], sep=' ')
        
        
main()
