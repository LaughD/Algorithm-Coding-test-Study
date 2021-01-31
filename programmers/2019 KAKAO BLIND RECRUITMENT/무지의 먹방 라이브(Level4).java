/*
    Code written on Jan 31, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 무지의 먹방 라이브(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/42891
*/
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] food_times, long k) {
        if (food_times.length > k)
            return (int) (1 + k);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int foodTime: food_times)
            pq.add(foodTime);

        int prevFoodTime = 0;
        while (!pq.isEmpty()) {
            long cycle = (long) (pq.peek() - prevFoodTime) * pq.size();
            if (cycle > k)
                break;
            k -= cycle;
            prevFoodTime = pq.poll();
            while ((!pq.isEmpty()) && (pq.peek() == prevFoodTime))
                pq.poll();
        }

        if (pq.isEmpty())
            return -1;

        k %= pq.size();
        int index = 0;
        for (int foodTime: food_times) {
            if (k < 0)
                break;            
            if (foodTime > prevFoodTime)
                k--;
            index++;
        }

        return index;
    }
}
