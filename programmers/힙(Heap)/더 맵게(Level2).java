/*
    Code written on Sep 21, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    힙(Heap): 더 맵게(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42626
*/
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilleUnit = new PriorityQueue<Integer>();
        int trials = 0;
            
        for (int eachScoville: scoville)
            scovilleUnit.add(eachScoville);
        
        while (scovilleUnit.peek() < K && scovilleUnit.size() > 1) {            
            scovilleUnit.add(scovilleUnit.poll() + scovilleUnit.poll()*2);
            trials++;
        }
        
        return scovilleUnit.peek() > K ? trials : -1;
    }
}
