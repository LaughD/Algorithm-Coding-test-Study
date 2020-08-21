'''
    Code written on May, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    01991번: 트리 순회
    link: https://www.acmicpc.net/problem/1991
'''
from sys import stdin


class node:
    def __init__(self, item, lc, rc):
        self.item = item
        self.lc = lc
        self.rc = rc

def preorder(node):
    print(node, end='')
    if tree[node].lc != '.':
        preorder(tree[node].lc)
    if tree[node].rc != '.':
        preorder(tree[node].rc)
    
def inorder(node): 
    if tree[node].lc != '.':
        inorder(tree[node].lc)
    print(node, end='')
    if tree[node].rc != '.':
        inorder(tree[node].rc)

def postorder(node): 
    if tree[node].lc != '.':
        postorder(tree[node].lc)
    if tree[node].rc != '.':
        postorder(tree[node].rc)
    print(node, end='')

count = int(input())
tree = {}
for i in range(count):
    item, lc, rc = stdin.readline().split()
    tree[item] = node(item, lc, rc)
preorder('A')
print()
inorder('A')
print()
postorder('A')
