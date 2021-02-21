/*
    Code written on Feb 21, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02110번: 공유기 설치
    link: https://www.acmicpc.net/problem/2110
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] houses = new int[n];

        for (int i = 0; i < n; i++)
            houses[i] = Integer.parseInt(br.readLine());
        Arrays.sort(houses);

        int left = 1;
        int right = (houses[n - 1] - houses[0]) / (c - 1);
        while (left <= right) {
            int mid = (left + right) / 2;
            int installed = 1;
            int baseHouse = houses[0];

            for (int targetHouse: houses) {
                if (targetHouse - baseHouse >= mid) {
                    baseHouse = targetHouse;
                    installed++;
                }
            }

            if (installed < c)
                right = mid - 1;
            else
                left = mid + 1;
        }

        System.out.print(right);
    }
}
