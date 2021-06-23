/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    09252 - LCS 2, https://www.acmicpc.net/problem/9252
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] stringA = reader.readLine().toCharArray();
        char[] stringB = reader.readLine().toCharArray();

        if (stringA.length < stringB.length) {
            char[] temp = stringA;
            stringA = stringB;
            stringB = temp;
        }

        int row = stringA.length;
        int col = stringB.length;
        int[][] dp = new int[1 + row][1 + col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (stringA[i] == stringB[j])
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
            if (dp[i][col] == col) {
                row = i + 1;
                break;
            }
        }

        System.out.println(dp[row][col]);
        if (dp[row][col] != 0) {
            char[] lcs = new char[dp[row][col]];
            int index = dp[row][col] - 1;
            while (index >= 0) {
                while (dp[row][col] == dp[row][col - 1])
                    col--;
                while (dp[row][col] == dp[row - 1][col])
                    row--;
                lcs[index--] = stringA[--row];
            }
            System.out.print(lcs);
        }
    }
}
