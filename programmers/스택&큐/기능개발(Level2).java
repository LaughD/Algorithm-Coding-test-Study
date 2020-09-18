/*
    Code written on Sep 19, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    스택/큐: 기능개발(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42586
*/
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Double> queue = new ArrayDeque<Double>();
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < progresses.length; i++) {
            double requiredDay = Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            if (!queue.isEmpty() && queue.peekFirst() < requiredDay) {
                answer.add(queue.size());
                queue.clear();
            }
            queue.add(requiredDay);
        }
        answer.add(queue.size());

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
