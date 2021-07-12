/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01735 - 분수 합, https://www.acmicpc.net/problem/1735
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numerator = Integer.parseInt(tokenizer.nextToken());
        int denominator = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int numeratorTemp = Integer.parseInt(tokenizer.nextToken());
        int denominatorTemp = Integer.parseInt(tokenizer.nextToken());

        numerator = numerator * denominatorTemp + denominator * numeratorTemp;
        denominator *= denominatorTemp;

        printIrreducibleFraction(numerator, denominator);
    }

    public static void printIrreducibleFraction(int numerator, int denominator) {
        int gcd = getGCD(numerator, denominator);
        System.out.print(numerator / gcd + " " + denominator / gcd);
    }

    public static int getGCD(int numberA, int numberB) {
        if (numberB == 0)
            return numberA;
        return getGCD(numberB, numberA % numberB);
    }
}
