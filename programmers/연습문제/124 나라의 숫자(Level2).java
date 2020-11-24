/*
    Code written on Nov 24, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 124 나라의 숫자(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12899
*/
import java.util.ArrayDeque;

class Solution {
    public String solution(int n) {
        ArrayDeque<String> deque = new ArrayDeque<String>();
        String[] numbers = {"4", "1", "2"};
        int remainder = n;
        
        while (n != 0) {
            remainder = n % 3;
            n /= 3;
            if (remainder == 0)
                n--;
            deque.addFirst(numbers[remainder]);
        }
        return String.join("", deque);
    }
}
