/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02023 - 신기한 소수, https://www.acmicpc.net/problem/2023
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder string;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int digits = Integer.parseInt(reader.readLine());
        string = new StringBuilder();

        digits--;
        for (int number: new int[] {2, 3, 5, 7})
            findAmazingPrimeNumbers(digits, number);
        System.out.print(string);
    }

    public static void findAmazingPrimeNumbers(int remainingDigits, int currentNumber) {
        if (remainingDigits == 0) {
            string.append(currentNumber).append("\n");
            return;
        }
        currentNumber *= 10;
        remainingDigits--;
        for (int number = 1; number < 10; number += 2) {
            currentNumber += number;
            if (isPrimeNumber(currentNumber))
                findAmazingPrimeNumbers(remainingDigits, currentNumber);
            currentNumber -= number;
        }
    }

    public static boolean isPrimeNumber(int number) {
        for (int quotient = 3; quotient <= Math.sqrt(number); quotient += 2)
            if (number % quotient == 0)
                return false;
        return true;
    }
}
