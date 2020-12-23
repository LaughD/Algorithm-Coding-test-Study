/*
    Code written on Dec 23, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 하노이의 탑(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12946
*/
class Solution {
    private int idx = 0;
    
    public int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2, n) - 1][2];
        return hanoi(n, 1, 3, 2, answer);
    }
    
    public int[][] hanoi(int n, int from, int to, int waypoint, int[][] answer) {
        if (n == 1) {
            answer[idx++] = new int[]{from, to};
            return answer;
        } else {
            hanoi(n - 1, from, waypoint, to, answer);
            answer[idx++] = new int[]{from, to};
            return hanoi(n-1, waypoint, to, from, answer);
        }
    }
}
