/*
    Code written on Mar 1, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01759번: 암호 만들기
    link: https://www.acmicpc.net/problem/1759
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] password;
    static char[] characters;
    static int l;
    static int c;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        password = new char[l];
        characters = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i ++)
            characters[i] = st.nextToken().charAt(0);
        Arrays.sort(characters);

        combination(0, 0);
        bw.flush();
    }

    public static void combination(int n, int index) throws Exception {
        if (n == l) {
            int nConsonant = 0;
            int nVowel = 0;
            for (char character: password) {
                if ((character == 'a') || (character == 'e') 
                        || (character == 'i') || (character == 'o') 
                        || (character == 'u'))
                    nVowel++;
                else
                    nConsonant++;
            }
            if ((nVowel > 0) && (nConsonant > 1)) {
                bw.write(String.valueOf(password));
                bw.newLine();
            }
            return;
        }

        int boundary = c - l + n;
        for (int i = index; i <= boundary; i++) {
            password[n] = characters[i];
            combination(n + 1, i + 1);
        }
    }
}
