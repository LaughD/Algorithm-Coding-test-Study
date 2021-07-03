/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    15486 - 퇴사 2, https://www.acmicpc.net/problem/15486
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[1 + n];
        int[] termList = new int[n];
        int[] payList = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            termList[i] = Integer.parseInt(tokenizer.nextToken());
            payList[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int day = n - 1; day > -1; day--) {
            int completionDay = day + termList[day];
            if (completionDay <= n)
                dp[day] = Math.max(dp[day + 1], payList[day] + dp[completionDay]);
            else
                dp[day] = dp[day + 1];
        }

        System.out.print(dp[0]);
    }
}
