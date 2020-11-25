/*
    Code written on Nov 25, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 2 x n 타일링(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12900
*/
class Solution {
    public int solution(int n) {
        int prev = 0;
        int now = 1;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = now;
            now = (prev + now) % 1000000007;
            prev = temp;
        }
        return now;
    }
}
