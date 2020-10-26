/*
    Code written on Oct 27, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 피보나치 수(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12945
*/
class Solution {
    public int solution(int n) {
        int front = 0, back = 1;
        for (int i = 1; i < n; i++) {
            int temp = back;
            back = (front + back) % 1234567;
            front = temp;
        }
        return back;
    }
}
