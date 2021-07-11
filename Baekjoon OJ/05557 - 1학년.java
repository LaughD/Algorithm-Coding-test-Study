/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    05557 - 1학년, https://www.acmicpc.net/problem/5557
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfNumbers = Integer.parseInt(reader.readLine()) - 1;
        long[][] dp = new long[21][numOfNumbers];
        int[] numbers = new int[numOfNumbers];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numOfNumbers; i++)
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        int targetNumber = Integer.parseInt(tokenizer.nextToken());

        numOfNumbers--;
        dp[numbers[0]][0] = 1;
        for (int col = 0; col < numOfNumbers; col++) {
            int number = numbers[col + 1];
            for (int row = 0; row <= 20; row++) {
                if (dp[row][col] != 0) {
                    if (number <= row)
                        dp[row - number][col + 1] += dp[row][col];
                    if (row + number <= 20)
                        dp[row + number][col + 1] += dp[row][col];
                }
            }
        }

        System.out.print(dp[targetNumber][numOfNumbers]);
    }
}
