/*
    Code written on Oct 29, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: N개의 최소공배수(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12953
*/
class Solution {
    public int solution(int[] arr) {
        int lcm = 1;
        for (int num: arr) 
            lcm = lcm * num / gcd(lcm, num);
        return lcm;
    }
    
    public int gcd(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return gcd(num2, num1%num2);
    }
}
