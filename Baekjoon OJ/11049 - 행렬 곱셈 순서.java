/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    11049 - 행렬 곱셈 순서, https://www.acmicpc.net/problem/11049
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfMatrices = Integer.parseInt(reader.readLine());
        int[][] matrices = new int[numOfMatrices][2];
        for (int i = 0; i < numOfMatrices; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            matrices[i][0] = Integer.parseInt(tokenizer.nextToken());
            matrices[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        printMinNumOfMultiplications(matrices, numOfMatrices);
    }

    public static void printMinNumOfMultiplications(int[][] matrices, int numOfMatrices) {
        int[][] dp = new int[numOfMatrices][numOfMatrices];
        final int INF = 2_147_483_647;

        for (int m = 1; m < numOfMatrices; m++) {
            int iBoundary = numOfMatrices - m;
            for (int i = 0; i < iBoundary; i++) {
                int j = i + m;
                dp[i][j] = INF;
                for (int k = i; k < j; k++) {
                    int numOfMultiplications = dp[i][k] + dp[k + 1][j] +
                            matrices[i][0] * matrices[k][1] * matrices[j][1];
                    if (numOfMultiplications < dp[i][j])
                        dp[i][j] = numOfMultiplications;
                }
            }
        }
        System.out.print(dp[0][numOfMatrices - 1]);
    }
}
