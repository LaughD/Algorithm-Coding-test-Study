/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    12015 - 가장 긴 증가하는 부분 수열 2, https://www.acmicpc.net/problem/12015
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] sequence;
    static int sequenceSize;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sequenceSize = Integer.parseInt(reader.readLine());
        sequence = new int[sequenceSize];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int index = 0; index < sequenceSize; index++)
            sequence[index] = Integer.parseInt(tokenizer.nextToken());

        printLongestIncreasingSubsequenceLength();
    }

    public static void printLongestIncreasingSubsequenceLength() {
        int[] lis = new int[sequenceSize];
        int lisSize = 0;
        final int INF = 1_000_001;

        lis[0] = INF;
        for (int element: sequence) {
            int index = Arrays.binarySearch(lis, 0, lisSize, element);
            if (index < 0) {
                index = -(index + 1);
                lis[index] = element;
                if (index != lisSize)
                    continue;
                if (++lisSize == sequenceSize)
                    break;
                lis[lisSize] = INF;
            }
        }
        System.out.print(lisSize);
    }
}
