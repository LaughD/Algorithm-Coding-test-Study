"""
    Python Version: Python 3.9.4
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    16506 - CPU, https://www.acmicpc.net/problem/16506
"""
from sys import stdin


def main():
    command_set = {"ADD": "00000", "ADDC": "00001", "SUB": "00010", "SUBC": "00011",
                   "MOV": "00100", "MOVC": "00101", "AND": "00110", "ANDC": "00111",
                   "OR": "01000", "ORC": "01001", "NOT": "01010", "MULT": "01100",
                   "MULTC": "01101", "LSFTL": "01110", "LSFTLC": "01111", "LSFTR": "10000",
                   "LSFTRC": "10001", "ASFTR": "10010", "ASFTRC": "10011", "RL": "10100",
                   "RLC": "10101", "RR": "10110", "RRC": "10111"}

    for _ in range(int(stdin.readline())):
        command, rd, ra, rb = stdin.readline().split()
        if command_set[command][-1] == '0':
            print(f"{command_set[command]}0{bin(int(rd))[2:]:>03}"
                  f"{bin(int(ra))[2:]:>03}{bin(int(rb))[2:]:>03}0")
        else:
            print(f"{command_set[command]}0{bin(int(rd))[2:]:>03}"
                  f"{bin(int(ra))[2:]:>03}{bin(int(rb))[2:]:>04}")


main()
