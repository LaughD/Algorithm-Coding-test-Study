/*
    Code written on Apr 27, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02193번: 이친수
    link: https://www.acmicpc.net/problem/2193
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] numPinaryNumber = new long[n + 1];
        numPinaryNumber[1] = 1;

        for (int digit = 2; digit <= n; digit++)
            numPinaryNumber[digit] = numPinaryNumber[digit - 1] + numPinaryNumber[digit - 2];

        System.out.print(numPinaryNumber[n]);
    }
}
