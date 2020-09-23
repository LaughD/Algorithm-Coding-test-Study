/*
    Code written on Sep 24, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 큰 수 만들기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42883
*/
import java.util.ArrayDeque;

class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> numLocker = new ArrayDeque<Character>();
        char[] answer = new char[number.length()-k];

        for (int i = 0; i < number.length(); i++) {
            while (!numLocker.isEmpty() && numLocker.getLast() < number.charAt(i) && k-- > 0)
                numLocker.pollLast();
            numLocker.addLast(number.charAt(i));
        }

        for (int i = 0; i < answer.length; i++)
            answer[i] = numLocker.pollFirst();
        
        return new String(answer);
    }
}
