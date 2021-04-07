/*
    Code written on Apr 7, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10275번: 골드 러시
    link: https://www.acmicpc.net/problem/10275
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOfTestCases = Integer.parseInt(br.readLine());

        for (int count = 0; count < numOfTestCases; count++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int log2_goldBarWeight = Integer.parseInt(st.nextToken());
            long backAWeight = Long.parseLong(st.nextToken());
            long backBWeight = Long.parseLong(st.nextToken());
            if (backAWeight <= backBWeight)
                bw.write(log2_goldBarWeight - log2(backAWeight & -backAWeight) + "\n");
            else
                bw.write(log2_goldBarWeight - log2(backBWeight & -backBWeight) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int log2(long value) { return (int) (Math.log(value) / Math.log(2)); }
}
