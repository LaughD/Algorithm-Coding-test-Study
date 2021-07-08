/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    11279 - 최대 힙, https://www.acmicpc.net/problem/11279
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder string = new StringBuilder();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int numOfOperations = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numOfOperations; i++) {
            int input = Integer.parseInt(reader.readLine());
            if (input == 0) {
                if (maxHeap.isEmpty())
                    string.append(0).append('\n');
                else
                    string.append(maxHeap.poll()).append('\n');
            } else {
                maxHeap.add(input);
            }
        }

        System.out.print(string);
    }
}
