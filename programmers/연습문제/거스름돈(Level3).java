/*
    Code written on Mar 29, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 거스름돈(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12907
*/
class Solution {
    public int solution(int n, int[] money) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int coin: money) {
            for (int i = 0; i <= n - coin; i++)
                dp[coin + i] += dp[i];
        }

        return (int) (dp[n] % 1000000007);
    }
}
