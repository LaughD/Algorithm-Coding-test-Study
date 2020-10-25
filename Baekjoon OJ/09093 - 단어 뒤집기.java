/*
    Code written on Oct 25, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    09093번: 단어 뒤집기
    link: https://www.acmicpc.net/problem/9093
*/
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] words = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            putReverseStr(words[0], sb);
            for (int j = 1; j < words.length; j++) {
                sb.append(" ");
                putReverseStr(words[j], sb);
            }
            bw.write(sb + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void putReverseStr(String str, StringBuilder sb) {
        char[] charArray = str.toCharArray();
        for (int i = str.length()-1; i > -1; i--)
            sb.append(charArray[i]);
    }
}
