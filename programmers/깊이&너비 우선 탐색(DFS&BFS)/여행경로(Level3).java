/*
    Code written on Jan 28, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    깊이/너비 우선 탐색(DFS/BFS): 여행경로(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43164
*/
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public String[] solution(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        ArrayDeque<String> route = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String[] ticket: tickets) {
            if (!graph.containsKey(ticket[0]))
                graph.put(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).add(ticket[1]);
        }

        stack.add("ICN");
        while (!stack.isEmpty()) {
            String city = stack.pollLast();
            if ((!graph.containsKey(city)) || (graph.get(city).isEmpty())) {
                route.addFirst(city);
            } else {
                stack.addLast(city);
                stack.addLast(graph.get(city).poll());
            }
        }

        return route.toArray(new String[0]);
    }
}
