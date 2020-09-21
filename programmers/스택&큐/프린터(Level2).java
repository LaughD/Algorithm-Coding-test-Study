/*
    Code written on Sep 21, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    스택/큐: 프린터(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42587
*/
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int idx = priorities.length - 1;
        int count = 0;

        Arrays.stream(priorities).boxed().forEach(queue::add);
        Arrays.sort(priorities);
 
        while (!queue.isEmpty()) {    
            final int front = queue.pollFirst();
            if (front == priorities[idx]) {
                count++;
                idx--;
                if (location == 0)
                    break;
            } else {
                queue.addLast(front);
            }
            location = (location + queue.size() - 1) % queue.size();
        }

        return count;
    }
}
