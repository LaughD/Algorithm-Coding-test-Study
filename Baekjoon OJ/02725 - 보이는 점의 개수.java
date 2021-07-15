/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02725 - 보이는 점의 개수, https://www.acmicpc.net/problem/2725
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder string = new StringBuilder();
        int numOfTestCases = Integer.parseInt(reader.readLine());
        int[] widthList = new int[numOfTestCases];
        int maxWidth = 1;
        for (int i = 0; i < numOfTestCases; i++)
            if (maxWidth < (widthList[i] = Integer.parseInt(reader.readLine())))
                maxWidth = widthList[i];

        int[] dp = new int[maxWidth + 1];
        dp[1] = 3;
        for (int width = 2; width <= maxWidth; width++) {
            dp[width] += dp[width - 1] + 2;
            for (int height = 2; height < width; height++)
                if (gcd(width, height) == 1)
                    dp[width] += 2;
        }

        for (int width: widthList)
            string.append(dp[width]).append("\n");
        System.out.print(string);
    }

    public static int gcd(int numberA, int numberB) {
        while (numberA % numberB != 0) {
            int temp = numberA;
            numberA = numberB;
            numberB = temp % numberB;
        }
        return numberB;
    }
}
