/*
    Code written on Nov 2, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 야근 지수(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12927
*/
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long overtimeIndex = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int work: works)
            pq.add(work);
        
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) break;
            else if (pq.peek() == 1) pq.poll();
            else pq.add(pq.poll()-1);
        }

        for (int overtime: pq)
            overtimeIndex += Math.pow(overtime, 2);
        return overtimeIndex;
    }
}
