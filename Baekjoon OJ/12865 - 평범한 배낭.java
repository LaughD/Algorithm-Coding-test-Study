/*
    Code written on Jan 1, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    12865번: 평범한 배낭
    link: https://www.acmicpc.net/problem/12865
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numArticles = Integer.parseInt(st.nextToken());
        int backWeight = Integer.parseInt(st.nextToken());
        int[] weights = new int[1+numArticles];
        int[] values = new int[1+numArticles];
        int[] optimalPacking = new int[1+backWeight];

        for (int i = 1; i <= numArticles; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= numArticles; i++) {
            for (int j = backWeight; j >= weights[i]; j--) {
                optimalPacking[j] = Math.max(
                        optimalPacking[j-weights[i]] + values[i],
                        optimalPacking[j]
                );
            }
        }

        System.out.println(optimalPacking[backWeight]);
    }
}
