/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02467 - 용액, https://www.acmicpc.net/problem/2467
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] solutionValues;
    static int numOfSolutions;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numOfSolutions = Integer.parseInt(reader.readLine());
        solutionValues = new int[numOfSolutions];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numOfSolutions; i++)
            solutionValues[i] = Integer.parseInt(tokenizer.nextToken());

        printValuesOfTwoSolutions();
    }

    public static void printValuesOfTwoSolutions() {
        int minValueSum = 2_000_000_000;
        int leftIndex = 0;
        int rightIndex = numOfSolutions - 1;
        int firstSolutionValue = solutionValues[leftIndex];
        int secondSolutionValue = solutionValues[rightIndex];

        while (leftIndex < rightIndex) {
            int leftSolutionValue = solutionValues[leftIndex];
            int rightSolutionValue = solutionValues[rightIndex];
            int valueSum = leftSolutionValue + rightSolutionValue;
            int absoluteValueSum = valueSum < 0 ? -valueSum : valueSum;

            if (absoluteValueSum < minValueSum) {
                minValueSum = absoluteValueSum;
                firstSolutionValue = leftSolutionValue;
                secondSolutionValue = rightSolutionValue;
            }
            if (valueSum > 0)
                rightIndex--;
            else if (valueSum < 0)
                leftIndex++;
            else
                break;
        }
        System.out.print(firstSolutionValue + " " + secondSolutionValue);
    }
}
