/*
    Code written on Oct 6, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2017 팁스타운: 짝지어 제거하기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12973
*/
import java.util.ArrayDeque;

class Solution{
    public int solution(String s) {
        ArrayDeque<Character> queue = new ArrayDeque<Character>();
        
        for (char character: s.toCharArray()) {
            if (!queue.isEmpty() && queue.getFirst() == character)
                queue.pollFirst();
            else
                queue.addFirst(character);
        }

        return queue.isEmpty() ? 1 : 0;
    }
}
