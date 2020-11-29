/*
    Code written on Nov 29, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    02309번: 일곱 난쟁이
    link: https://www.acmicpc.net/problem/2309
*/
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }

        loop:
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum-numbers[i]-numbers[j] == 100) {
                    numbers[i] = numbers[j] = 0;
                    Arrays.sort(numbers);
                    for (int number: numbers)
                        if (number != 0)
                            bw.write( String.valueOf(number) + '\n');
                    bw.flush();
                    bw.close();
                    break loop;
                }
            }
        }
    }
}
