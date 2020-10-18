/*
    Code written on Oct 18, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: JadenCase 문자열 만들기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12951
*/
class Solution {
    public String solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        boolean isWordHead = true;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                isWordHead = true;
            } else {
                if (isWordHead && Character.isLetter(chars[i]))
                    chars[i] = Character.toUpperCase(chars[i]);    
                isWordHead = false;
            }
        }

        return String.valueOf(chars);
    }
}
