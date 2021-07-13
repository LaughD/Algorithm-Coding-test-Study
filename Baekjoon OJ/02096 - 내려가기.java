/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02096 - 내려가기, https://www.acmicpc.net/problem/2096
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfLines = Integer.parseInt(reader.readLine());
        int[][] dpMax = new int[numOfLines + 1][3];
        int[][] dpMin = new int[numOfLines + 1][3];

        for (int i = 1; i <= numOfLines; i++) {
            char[] line = reader.readLine().toCharArray();
            int smallerLeftAndMiddle = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
            int smallerMiddleAndRight = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]);
            int biggerLeftAndMiddle = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            int biggerMiddleAndRight = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]);

            dpMin[i][0] = dpMax[i][0] = line[0] - '0';
            dpMin[i][1] = dpMax[i][1] = line[2] - '0';
            dpMin[i][2] = dpMax[i][2] = line[4] - '0';
            dpMin[i][0] += smallerLeftAndMiddle;
            dpMin[i][1] += Math.min(smallerLeftAndMiddle, smallerMiddleAndRight);
            dpMin[i][2] += smallerMiddleAndRight;
            dpMax[i][0] += biggerLeftAndMiddle;
            dpMax[i][1] += Math.max(biggerLeftAndMiddle, biggerMiddleAndRight);
            dpMax[i][2] += biggerMiddleAndRight;
        }

        int max = 0;
        int min = 900001;
        for (int i = 0; i < 3; i++) {
            if (max < dpMax[numOfLines][i])
                max = dpMax[numOfLines][i];
            if (min > dpMin[numOfLines][i])
                min = dpMin[numOfLines][i];
        }
        System.out.print(max + " " + min);
    }
}
