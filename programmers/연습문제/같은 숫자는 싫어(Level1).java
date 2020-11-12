/*
    Code written on Nov 12, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 같은 숫자는 싫어(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/12906
*/
import java.util.ArrayDeque;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.addLast(arr[0]);
        for (int num: arr)
            if (num != queue.peekLast())
                queue.addLast(num);
        
        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = queue.pollFirst();
        return answer;
    }
}
