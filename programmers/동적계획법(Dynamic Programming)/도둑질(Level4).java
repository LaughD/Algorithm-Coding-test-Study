/*
    Code written on Nov 18, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    동적계획법(Dynamic Programming): 도둑질(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/42897
*/
class Solution {
    public int solution(int[] money) {
        int prev, temp;
        
        int firstCase = prev = money[0];
        for (int i = 2; i < money.length-1; i++) {
            temp = firstCase;
            firstCase = Math.max(firstCase, prev+money[i]);
            prev = temp;
        }
        
        int secondCase = prev = 0;
        for (int i = 1; i < money.length; i++) {
            temp = secondCase;
            secondCase = Math.max(secondCase, prev+money[i]);
            prev = temp;
        }
        
        return Math.max(firstCase, secondCase);
    }
}
