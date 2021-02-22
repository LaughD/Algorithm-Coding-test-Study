/*
    Code written on Feb 23, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 3 x n 타일링(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/12902
*/
class Solution {
    public int solution(int n) {
        if (n % 2 == 1)
            return 0;

        final int MOD = 1000000007;
        int half = n / 2;
        long[] dp = new long[half + 1];

        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= half; i++) {
            dp[i] = (4 * dp[i - 1]) - dp[i - 2];
            dp[i] = dp[i] < 0 ? dp[i] + MOD : dp[i] % MOD;
        }
        return (int) dp[half];
    }
}
