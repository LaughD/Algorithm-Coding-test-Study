/*
    Code written on Sep 26, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    그래프: 가장 먼 노드(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/49189
*/
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[][] edge) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[n+1];
        int answer = 1;

        for (int[] nodes: edge) {
            if (!graph.containsKey(nodes[0]))
                graph.put(nodes[0], new HashSet<Integer>());
            graph.get(nodes[0]).add(nodes[1]);
            if (!graph.containsKey(nodes[1]))
                graph.put(nodes[1], new HashSet<Integer>());
            graph.get(nodes[1]).add(nodes[0]);
        }
        
        queue.addLast(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            answer = queue.size();
            for (int i = 0; i < answer; i++) {
                int node = queue.pollFirst();
                for (int child: graph.get(node)) {
                    if (!visited[child]) {
                        visited[child] = true;
                        queue.addLast(child);
                    }
                }
            }
        }

        return answer;
    }
}
