/*
    Code written on Oct 27, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 올바른 괄호(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12909
*/
class Solution {
    boolean solution(String s) {
        int sign = 0;
        for (char bracket: s.toCharArray()) {
            if (bracket == '(')
                sign++;
            else
                sign--;
            if (sign < 0)
                break;
        }
        return sign == 0;
    }
}
