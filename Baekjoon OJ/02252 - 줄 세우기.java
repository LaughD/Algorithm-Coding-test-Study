/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02252 - 줄 세우기, https://www.acmicpc.net/problem/2252
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> latecomers = new ArrayList<>();
    static int numOfStudents;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        numOfStudents = Integer.parseInt(tokenizer.nextToken());
        int numOfCompares = Integer.parseInt(tokenizer.nextToken());
        int[] inDegree = new int[1 + numOfStudents];

        for (int i = 0; i <= numOfStudents; i++)
            latecomers.add(new ArrayList<>());
        for (int i = 0; i < numOfCompares; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int front = Integer.parseInt(tokenizer.nextToken());
            int back = Integer.parseInt(tokenizer.nextToken());
            latecomers.get(front).add(back);
            inDegree[back] += 1;
        }

        printLine(inDegree);
    }

    public static void printLine(int[] inDegree) {
        StringBuilder string = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= numOfStudents; i++)
            if (inDegree[i] == 0)
                queue.add(i);

        while (!queue.isEmpty()) {
            int student = queue.pollFirst();
            string.append(student).append(' ');
            for (int latecomer: latecomers.get(student))
                if (--inDegree[latecomer] == 0)
                    queue.add(latecomer);
        }

        System.out.print(string);
    }
}
