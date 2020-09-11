'''
    Code written on Sep 11, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 길 찾기 게임(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42892
'''
class Tree:
    def __init__(self, nodeinfo, left=None, right=None):
        self.num = nodeinfo[0]
        self.x = nodeinfo[1][0]
        self.y = nodeinfo[1][1]
        self.left = left
        self.right = right


def solution(nodeinfo):
    nodeinfo = sorted(zip(range(1, len(nodeinfo)+1), nodeinfo), key=lambda x: (-x[1][1], x[1][0]))
    root = Tree(nodeinfo[0])
    for node in nodeinfo:
        node = Tree(node)
        subroot = root
        while subroot:
            if subroot.x > node.x:
                if not subroot.left:
                    subroot.left = node
                    break
                subroot = subroot.left
            elif subroot.x < node.x:
                if not subroot.right:
                    subroot.right = node
                    break
                subroot = subroot.right
            else:
                subroot = None
    return [preorder(root), postorder(root)]


def preorder(root):
    result = []
    stack = [root]
    while stack:
        node = stack.pop()
        result.append(node.num)
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)
    return result


def postorder(root):
    past = set()
    result = []
    stack = [root]
    while stack:
        node = stack.pop()
        if node.num in past or (not node.left and not node.right):
            result.append(node.num)
        else:
            stack.append(node)
            past.add(node.num)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)       
    return result
