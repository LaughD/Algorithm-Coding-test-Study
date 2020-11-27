/*
    Code written on Nov 27, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    14719번: 빗물
    link: https://www.acmicpc.net/problem/14719
*/
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] blocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int WIDTH = blocks.length;

        int[] leftToRight = new int[WIDTH+1];
        for (int i = 0; i < WIDTH; i++)
            leftToRight[i+1] = Math.max(leftToRight[i], blocks[i]);

        int[] rightToLeft = new int[WIDTH+2];
        for (int i = WIDTH; i > 0; i--)
            rightToLeft[i] = Math.max(rightToLeft[i+1], blocks[i-1]);

        int rainwater = 0;
        for (int i = 1; i <= WIDTH; i++)
            rainwater += Math.min(leftToRight[i], rightToLeft[i]) - blocks[i-1];

        System.out.print(rainwater);
    }
}
