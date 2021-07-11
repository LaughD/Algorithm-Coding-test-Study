/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    11659 - 구간 합 구하기 4, https://www.acmicpc.net/problem/11659
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder string = new StringBuilder();
        int numOfNumbers = Integer.parseInt(tokenizer.nextToken());
        int count = Integer.parseInt(tokenizer.nextToken());
        int[] prefixSum = new int[1 + numOfNumbers];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int index = 1; index <= numOfNumbers; index++)
            prefixSum[index] = prefixSum[index - 1] + Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < count; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            string.append(
                    -prefixSum[Integer.parseInt(tokenizer.nextToken()) - 1]
                    + prefixSum[Integer.parseInt(tokenizer.nextToken())]
            ).append("\n");
        }

        System.out.print(string);
    }
}
