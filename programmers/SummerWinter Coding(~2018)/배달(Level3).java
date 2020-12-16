/*
    Code written on Dec 16, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 배달(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12978
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    static class DeliveryCost implements Comparable<DeliveryCost> {
        private final int TOWN;
        private final int COST;

        public DeliveryCost(int TOWN, int COST) {
            this.TOWN = TOWN;
            this.COST = COST;
        }

        @Override
        public int compareTo(DeliveryCost dc) {
            return this.COST - dc.COST;
        }
    }    
    
    public int solution(int N, int[][] road, int K) {
        HashMap<Integer, ArrayList<DeliveryCost>> deliveryInfos = new HashMap<>();
        PriorityQueue<DeliveryCost> pq = new PriorityQueue<>();
        DeliveryCost pqHead;
        int[] cost = new int[N+1];

        for (int i = 0; i <= N; i++) {
            deliveryInfos.put(i, new ArrayList<>());
        }
        for (int[] route : road) {
            deliveryInfos.get(route[0]).
                    add(new DeliveryCost(route[1], route[2]));
            deliveryInfos.get(route[1]).
                    add(new DeliveryCost(route[0], route[2]));
        }
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;

        pq.add(new DeliveryCost(1, 0));
        while (!pq.isEmpty()) {
            pqHead = pq.poll();
            if (pqHead.COST <= cost[pqHead.TOWN]) {
                for (DeliveryCost route: deliveryInfos.get(pqHead.TOWN)) {
                    int newRouteDistance = pqHead.COST + route.COST;
                    if (newRouteDistance < cost[route.TOWN]) {
                        cost[route.TOWN] = newRouteDistance;
                        pq.add(new DeliveryCost(route.TOWN, cost[route.TOWN]));
                    }
                }
            }
        }
        
        return (int) Arrays.stream(cost).
                filter(c -> c <= K).count();
    }
}
