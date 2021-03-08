/*
    Code written on Mar 8, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 길 찾기 게임(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42892
*/
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int numOfNodes = nodeinfo.length;
        int[][] orderResults = new int[2][numOfNodes];
        Node[] nodes = new Node[numOfNodes];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int nodeIndex = 0; nodeIndex < numOfNodes; nodeIndex++)
            nodes[nodeIndex] = new Node(nodeIndex + 1, nodeinfo[nodeIndex]);
        Arrays.sort(nodes, (node1, node2) -> node2.coordinateY - node1.coordinateY);

        for (int nodeIndex = 1; nodeIndex < numOfNodes; nodeIndex++)
            Node.addChildNode(nodes[0], nodes[nodeIndex]);

        Node.preorder(nodes[0], deque);
        Node.writeOrderResult(orderResults[0], deque);
        Node.postorder(nodes[0], deque);
        Node.writeOrderResult(orderResults[1], deque);

        return orderResults;
    }

    static class Node {
        int nodeNumber;
        int coordinateX;
        int coordinateY;
        Node leftChild = null;
        Node rightChild = null;

        public Node(int nodeNumber, int[] coordinate) {
            this.nodeNumber = nodeNumber;
            this.coordinateX = coordinate[0];
            this.coordinateY = coordinate[1];
        }

        public static void addChildNode(Node parentNode, Node childNode) {
            if (parentNode.coordinateX > childNode.coordinateX) {
                if (parentNode.leftChild == null)
                    parentNode.leftChild = childNode;
                else
                    addChildNode(parentNode.leftChild, childNode);
            } else {
                if (parentNode.rightChild == null)
                    parentNode.rightChild = childNode;
                else
                    addChildNode(parentNode.rightChild, childNode);
            }
        }

        public static void preorder(Node node, ArrayDeque<Integer> deque) {
            if (node != null) {
                deque.addLast(node.nodeNumber);
                preorder(node.leftChild, deque);
                preorder(node.rightChild, deque);
            }
        }

        public static void postorder(Node node, ArrayDeque<Integer> deque) {
            if (node != null) {
                postorder(node.leftChild, deque);
                postorder(node.rightChild, deque);
                deque.addLast(node.nodeNumber);
            }
        }

        public static void writeOrderResult(int[] orderResult, ArrayDeque<Integer> deque) {
            int numOfNodes = orderResult.length;
            for (int nodeIndex = 0; nodeIndex < numOfNodes; nodeIndex++)
                orderResult[nodeIndex] = deque.pollFirst();
        }
    }
}
