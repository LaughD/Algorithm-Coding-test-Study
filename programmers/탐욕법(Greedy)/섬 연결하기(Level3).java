/*
    Code written on Sep 27, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 섬 연결하기(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42861
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Comparator;

class Solution {
    public int solution(int n, int[][] costs) {
        final int edgeTotal = n-1;
        int edgeNum = 0, costSum = 0;
        HashMap<Integer, Integer> graph = new HashMap<Integer, Integer>();
        
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] cost1, int[] cost2) {
                return cost1[2] - cost2[2];
            }
        });
   
        for (int[] cost: costs) {
            graph.put(cost[0], cost[0]);
            graph.put(cost[1], cost[1]);
        }
        
        for (int[] cost: costs) {
            int parentsOne = graph.get(cost[0]), parentsTwo = graph.get(cost[1]);
            if (parentsOne != parentsTwo) {
                for (int node: graph.keySet()) {
                    if (graph.get(node) == parentsTwo)
                        graph.put(node, parentsOne);
                }
                edgeNum++;
                costSum += cost[2];
            }
            if (edgeNum == edgeTotal)
                break;
        }
        
        return costSum;
    }
}
