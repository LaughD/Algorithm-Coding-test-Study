/*
    Code written on Nov 28, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    05568번: 카드 놓기
    link: https://www.acmicpc.net/problem/5568
*/
import java.io.*;
import java.util.HashSet;

public class Main {
    static HashSet<String> numberSet = new HashSet<>();
    static int n;
    static int k;
    static String[] cards;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new String[n];
        selected = new boolean[n];
        for (int i = 0 ; i < n; i++)
            cards[i] = br.readLine();
        permutations(0, new String[k]);
        System.out.print(numberSet.size());
    }

    public static void permutations(int count, String[] selectedCards) {
        if (count == k) {
            numberSet.add(String.join("", selectedCards));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                selectedCards[count] = cards[i];
                permutations(count+1, selectedCards);
                selected[i] = false;
            }
        }
    }
}
