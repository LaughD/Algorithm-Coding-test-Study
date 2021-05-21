/*
    Code written on May 21, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    09251번: LCS
    link: https://www.acmicpc.net/problem/9251
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] firstString = reader.readLine().toCharArray();
        char[] secondString = reader.readLine().toCharArray();
        int[][] dp = new int[1 + firstString.length][1 + secondString.length];

        for (int row = 0; row < firstString.length; row++) {
            for (int col = 0; col < secondString.length; col++) {
                if (firstString[row] == secondString[col]) {
                    dp[row + 1][col + 1] = dp[row][col] + 1;
                    continue;
                }
                dp[row + 1][col + 1] = Math.max(dp[row][col + 1], dp[row + 1][col]);
            }
        }
        System.out.print(dp[firstString.length][secondString.length]);
    }
}
