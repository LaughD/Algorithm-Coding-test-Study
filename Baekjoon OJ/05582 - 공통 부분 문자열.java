/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    05582 - 공통 부분 문자열, https://www.acmicpc.net/problem/5582
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] stringA = reader.readLine().toCharArray();
        char[] stringB = reader.readLine().toCharArray();
        int stringALength = stringA.length;
        int stringBLength = stringB.length;
        int longestLength = 0;
        int[][] dp = new int[1 + stringALength][1 + stringBLength];

        for (int row = 0; row < stringALength; row++)
            for (int col = 0; col < stringBLength; col++)
                if (stringA[row] == stringB[col])
                    longestLength = Math.max(
                            longestLength,
                            dp[row + 1][col + 1] = dp[row][col] + 1
                    );

        System.out.print(longestLength);
    }
}
