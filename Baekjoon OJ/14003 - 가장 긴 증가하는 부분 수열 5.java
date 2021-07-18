/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    14003 - 가장 긴 증가하는 부분 수열 5, https://www.acmicpc.net/problem/14003
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sequenceSize = Integer.parseInt(reader.readLine());
        int[] sequence = new int[sequenceSize];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < sequenceSize; i++)
            sequence[i] = Integer.parseInt(tokenizer.nextToken());

        printLongestIncreasingSubsequence(sequence, sequenceSize);
    }

    public static void printLongestIncreasingSubsequence(int[] sequence, int sequenceSize) {
        StringBuilder string = new StringBuilder();
        int[] dp = new int[sequenceSize];
        int[] lisIndices = new int[sequenceSize];
        int lisSize = 0;
        final int INF = 1_000_000_001;

        dp[0] = INF;
        for (int sequenceIndex = 0; sequenceIndex < sequenceSize; sequenceIndex++) {
            int dpIndex = Arrays.binarySearch(dp, 0, lisSize, sequence[sequenceIndex]);
            if (dpIndex < 0) {
                dpIndex = -(dpIndex + 1);
                dp[dpIndex] = sequence[sequenceIndex];
                if (dpIndex == lisSize && ++lisSize != sequenceSize)
                    dp[lisSize] = INF;
            }
            lisIndices[sequenceIndex] = dpIndex;
        }

        string.append(lisSize).append("\n");
        int[] lis = new int[lisSize--];
        for (int i = sequenceSize - 1; i > -1; i--) {
            if (lisIndices[i] == lisSize)
                lis[lisSize--] = sequence[i];
            if (lisSize < 0)
                break;
        }
        for (int element: lis)
            string.append(element).append(' ');
        System.out.print(string);
    }
}
