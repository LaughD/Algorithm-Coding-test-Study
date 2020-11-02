/*
    Code written on Nov 2, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 멀리 뛰기(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12914
*/
class Solution {
    public long solution(int n) {
        int front = 1, back = 1, temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = back;
            back = (front + back) % 1234567;
            front = temp;
        }
        return back;            
    }
}
