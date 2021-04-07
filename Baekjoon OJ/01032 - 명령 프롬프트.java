/*
    Code written on Apr 7, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01032번: 명령 프롬프트
    link: https://www.acmicpc.net/problem/1032
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfFiles = Integer.parseInt(br.readLine());
        char[] pattern = br.readLine().toCharArray();
        int fileNameLength = pattern.length;

        for (int fileIndex = 1; fileIndex < numOfFiles; fileIndex++) {
            char[] fileName = br.readLine().toCharArray();
            for (int index = 0; index < fileNameLength; index++)
                if (pattern[index] != fileName[index])
                    pattern[index] = '?';
        }
        System.out.print(pattern);
    }
}
