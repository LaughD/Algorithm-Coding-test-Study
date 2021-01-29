/*
    Code written on Jan 29, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01439번: 뒤집기
    link: https://www.acmicpc.net/problem/1439
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();
        int count = 0;
        char prev = ' ';

        for (char character: string) {
            if (prev != character) {
                count++;
                prev = character;
            }
        }
        System.out.print(count / 2);
    }
}
