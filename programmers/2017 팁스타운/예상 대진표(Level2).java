/*
    Code written on Mar 31, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2017 팁스타운: 예상 대진표(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12985
*/
class Solution {
    public int solution(int n, int a, int b) {
        int numGames = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            numGames++;
        }

        return numGames;
    }
}
