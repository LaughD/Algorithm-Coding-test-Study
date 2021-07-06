/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02003 - 수들의 합 2, https://www.acmicpc.net/problem/2003
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int sequenceSize = Integer.parseInt(tokenizer.nextToken());
        int targetNumber = Integer.parseInt(tokenizer.nextToken());
        int[] sequence = new int[sequenceSize];
        int sum = 0;
        int tail = 0;
        int numOfCases = 0;

        tokenizer = new StringTokenizer(reader.readLine());
        for (int index = 0 ; index < sequenceSize; index++)
            sequence[index] = Integer.parseInt(tokenizer.nextToken());

        for (int head = 0; head < sequenceSize; head++) {
            while (tail < sequenceSize && sum < targetNumber)
                sum += sequence[tail++];
            if (sum == targetNumber)
                numOfCases++;
            sum -= sequence[head];
        }

        System.out.print(numOfCases);
    }
}
