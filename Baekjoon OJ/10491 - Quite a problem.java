/*
    Code written on Oct 24, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    10491번: Quite a problem
    link: https://www.acmicpc.net/problem/10491
*/
import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pattern pattern = Pattern.compile("(.*problem.*)", Pattern.CASE_INSENSITIVE);
        String str;
        while ((str = br.readLine()) != null) {
            if (pattern.matcher(str).find())
                bw.write("yes\n");
            else
                bw.write("no\n");
        }
        bw.flush();
        bw.close();
    }
}
