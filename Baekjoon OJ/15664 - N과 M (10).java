/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    15664 - N과 M (10), https://www.acmicpc.net/problem/15664
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder string = new StringBuilder();
    static int numOfNumbers;
    static int permutationLength;
    static String[] permutation;
    static int[] numbers;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        numOfNumbers = Integer.parseInt(tokenizer.nextToken());
        permutationLength = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        permutation = new String[permutationLength];
        numbers = new int[numOfNumbers];
        selected = new boolean[numOfNumbers];
        for (int i = 0 ; i < numOfNumbers; i++)
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(numbers);

        permutations(0, 0);
        System.out.print(string);
    }

    public static void permutations(int turn, int index) {
        if (turn == permutationLength) {
            string.append(String.join(" ", permutation)).append("\n");
            return;
        }
        int lastNumber = 0;
        for (int currentIndex = index; currentIndex < numOfNumbers; currentIndex++) {
            if (selected[currentIndex] || lastNumber == numbers[currentIndex])
                continue;
            selected[currentIndex] = true;
            lastNumber = numbers[currentIndex];
            permutation[turn] = String.valueOf(lastNumber);
            permutations(turn + 1, currentIndex + 1);
            selected[currentIndex] = false;
        }
    }
}
