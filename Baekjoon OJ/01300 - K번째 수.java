/*
    Code written on Jan 8, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01300번: K번째 수
    link: https://www.acmicpc.net/problem/1300
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int headNum = 1;
        int tailNum = k;

        while (headNum <= tailNum) {
            int midNum = (headNum+tailNum) / 2;
            int count = 0;

            for (int i = 1; i <= n; i++) {
                count += Math.min(midNum/i, n);
            }
            if (count < k) {
                headNum = midNum + 1;
            } else {
                tailNum = midNum -1;
            }
        }

        System.out.print(headNum);
    }
}
