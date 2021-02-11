/*
    Code written on Feb 12, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18310번: 안테나
    link: https://www.acmicpc.net/problem/18310
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] houses = new int[n];

        for (int i = 0; i < n; i++)
            houses[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(houses);

        System.out.print(houses[(n-1)/2]);
    }
}
