/*
    Code written on Jan 7, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    11444번: 피보나치 수 6
    link: https://www.acmicpc.net/problem/11444
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] fibonacciMatrix = {{1, 1}, {1, 0}};
        long[][] resultMatrix = {{1, 0}, {0, 1}};

        while (n > 0) {
            if (n % 2 == 1) {
                resultMatrix = matrixMul(resultMatrix, fibonacciMatrix);
            }
            fibonacciMatrix = matrixMul(fibonacciMatrix, fibonacciMatrix);
            n /= 2;
        }

        System.out.print(resultMatrix[0][1]);
    }

    public static long[][] matrixMul(long[][] matrixA, long[][] matrixB) {
        long[][] newMatrix = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long sum = 0;
                for (int k = 0; k < 2; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                newMatrix[i][j] = sum % 1000000007;
            }
        }

        return newMatrix;
    }
}
