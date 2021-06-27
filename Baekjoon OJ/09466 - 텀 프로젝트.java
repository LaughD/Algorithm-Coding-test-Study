/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    09466 - 텀 프로젝트, https://www.acmicpc.net/problem/9466
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder string = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int numOfTestCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfTestCases; i++)
            printNumOfRemainingStudents();
        System.out.print(string);
    }

    public static void printNumOfRemainingStudents() throws Exception {
        int numOfStudents = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numOfRemainingStudents = 0;
        int[] pointOut = new int[1 + numOfStudents];
        int[] queue = new int[numOfStudents];

        for (int student = 1; student <= numOfStudents; student++)
            pointOut[student] = Integer.parseInt(tokenizer.nextToken());

        for (int student = 1; student <= numOfStudents; student++) {
            if (pointOut[student] == student)
                continue;

            int chooser = student;
            int index = 0;
            int temp;

            while (pointOut[chooser] != chooser) {
                queue[index++] = chooser;
                temp = pointOut[chooser];
                pointOut[chooser] = chooser;
                chooser = temp;
            }

            numOfRemainingStudents += index;
            for (int j = 0; j < index; j++) {
                if (queue[j] == chooser) {
                    numOfRemainingStudents -= index - j;
                    break;
                }
            }
        }

        string.append(numOfRemainingStudents).append("\n");
    }
}
