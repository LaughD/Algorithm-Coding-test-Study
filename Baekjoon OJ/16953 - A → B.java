/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    16953 - A → B, https://www.acmicpc.net/problem/16953
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numberA = Integer.parseInt(tokenizer.nextToken());
        int numberB = Integer.parseInt(tokenizer.nextToken());
        int count = 0;

        while (true) {
            if (numberA == numberB) {
                System.out.print(count + 1);
                break;
            } else if (numberB == 0) {
                System.out.print(-1);
                break;
            } else if (numberB % 10 == 1) {
                numberB /= 10;
            } else if (numberB % 2 == 0){
                numberB /= 2;
            } else {
                System.out.print(-1);
                break;
            }
            count++;
        }
    }
}
