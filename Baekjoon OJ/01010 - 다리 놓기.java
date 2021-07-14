/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01010 - 다리 놓기, https://www.acmicpc.net/problem/1010
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] binomialCoefficient = new int[31][31];

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder string = new StringBuilder();
        int numOfTestCases = Integer.parseInt(reader.readLine());
        int[] nList = new int[numOfTestCases];
        int[] kList = new int[numOfTestCases];
        int nMax = 0;
        int kMax = 0;
        for (int i = 0; i < numOfTestCases; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            kList[i] = Integer.parseInt(tokenizer.nextToken());
            nList[i] = Integer.parseInt(tokenizer.nextToken());
            if (nList[i] > nMax)
                nMax = nList[i];
            if (kList[i] > kMax)
                kMax = kList[i];
        }
        setBinomialCoefficient(nMax, kMax);

        for (int i = 0; i < numOfTestCases; i++)
            string.append(binomialCoefficient[nList[i]][kList[i]]).append("\n");
        System.out.print(string);
    }

    public static void setBinomialCoefficient(int n, int k) {
        for (int i = 0; i <= n; i++) {
            int boundary = Math.min(i, k);
            for (int j = 0; j <= boundary; j++) {
                if (j == 0 || i == j)
                    binomialCoefficient[i][j] = 1;
                else
                    binomialCoefficient[i][j] =
                            binomialCoefficient[i - 1][j - 1] + binomialCoefficient[i - 1][j];
            }
        }
    }
}
