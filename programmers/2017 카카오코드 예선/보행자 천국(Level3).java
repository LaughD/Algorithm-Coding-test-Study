/*
    Code written on Oct 22, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2017 카카오코드 예선: 보행자 천국(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/1832
*/
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 2) {
                    if (j > 0)
                        dp[i][j] = dp[i][j-1];
                } else if (cityMap[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int k = i-1;
                    if (j > 0) 
                        dp[i][j] = dp[i][j-1];
                    while (k > -1 && cityMap[k][j] == 2)
                        k--;
                    if (k > -1)
                        dp[i][j] = (dp[i][j] + dp[k][j]) % 20170805;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
