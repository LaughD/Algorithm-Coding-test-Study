/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01644 - 소수의 연속합, https://www.acmicpc.net/problem/1644
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] primeNumbers = new int[400000];
    static int numOfPrimeNumbers = 0;
    static int number;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(reader.readLine());
        findPrimeNumbers();
        System.out.print(calcNumOfCases());
    }

    public static void findPrimeNumbers() {
        boolean[] isNoPrime = new boolean[number + 1];
        int prevPrimeNumber = primeNumbers[numOfPrimeNumbers++] = 2;

        for (int i = 3; i <= number; i += 2) {
            if (isNoPrime[i])
                continue;
            if (prevPrimeNumber + i > number)
                break;
            primeNumbers[numOfPrimeNumbers++] = prevPrimeNumber = i;
            for (int j = i * 2; j <= number; j += i)
                isNoPrime[j] = true;
        }
        if (number > 2 && number % 2 != 0 && !isNoPrime[number])
            primeNumbers[numOfPrimeNumbers++] = number;
    }

    public static int calcNumOfCases() {
        int numOfCases = 0;
        int tailIndex = 0;
        int sumOfPrimeNumbers = 0;

        loop:
        for (int primeNumber : primeNumbers) {
            while (sumOfPrimeNumbers < number) {
                if (tailIndex == numOfPrimeNumbers)
                    break loop;
                sumOfPrimeNumbers += primeNumbers[tailIndex++];
            }
            if (sumOfPrimeNumbers == number)
                numOfCases++;
            sumOfPrimeNumbers -= primeNumber;
        }
        return numOfCases;
    }
}
