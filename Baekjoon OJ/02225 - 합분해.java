/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02225 - 합분해, https://www.acmicpc.net/problem/2225
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++)
            dp[i][0] = 1;
        for (int i = 0; i <= n; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= k; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_000;

        System.out.print(dp[k][n]);
    }
}
