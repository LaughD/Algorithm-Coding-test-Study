/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02579 - 계단 오르기, https://www.acmicpc.net/problem/2579
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfStairs = Integer.parseInt(reader.readLine());
        int[] dp = new int[numOfStairs + 1];
        int[] stairs = new int[numOfStairs + 1];
        for (int i = 1; i <= numOfStairs; i++)
            dp[i] = stairs[i] = Integer.parseInt(reader.readLine());

        if (numOfStairs > 1) {
            dp[2] += dp[1];
            for (int i = 3; i <= numOfStairs; i++)
                dp[i] += Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]);
        }
        System.out.print(dp[numOfStairs]);
    }
}
