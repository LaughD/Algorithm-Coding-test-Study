/*
    Code written on May 19, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01937번: 욕심쟁이 판다
    link: https://www.acmicpc.net/problem/1937
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] wood;
    private static int[][] dp;
    private static int woodWidth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxDays = 1;
        woodWidth = Integer.parseInt(br.readLine());
        wood = new int[woodWidth][woodWidth];
        dp = new int[woodWidth][woodWidth];

        for (int row = 0; row < woodWidth; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < woodWidth; col++)
                wood[row][col] = Integer.parseInt(st.nextToken());
        }

        for (int row = 0; row < woodWidth; row++) {
            for (int col = 0; col < woodWidth; col++) {
                if (dp[row][col] == 0) {
                    startEating(row, col);
                    maxDays = Math.max(maxDays, dp[row][col]);
                }
            }
        }
        System.out.print(maxDays);
    }

    public static int startEating(int row, int col) {
        if (dp[row][col] != 0)
            return dp[row][col];
        if (row > 0 && wood[row - 1][col] > wood[row][col])
            dp[row][col] = Math.max(dp[row][col], startEating(row - 1, col));
        if (col > 0 && wood[row][col - 1] > wood[row][col])
            dp[row][col] = Math.max(dp[row][col], startEating(row, col - 1));
        if (row < woodWidth - 1 && wood[row + 1][col] > wood[row][col])
            dp[row][col] = Math.max(dp[row][col], startEating(row + 1, col));
        if (col < woodWidth - 1 && wood[row][col + 1] > wood[row][col])
            dp[row][col] = Math.max(dp[row][col], startEating(row, col + 1));
        return dp[row][col] += 1;
    }
}
