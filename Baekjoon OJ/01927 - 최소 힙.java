/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01927 - 최소 힙, https://www.acmicpc.net/problem/1927
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder string = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int numOfOperations = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numOfOperations; i++) {
            int input = Integer.parseInt(reader.readLine());
            if (input == 0) {
                if (minHeap.isEmpty())
                    string.append(0).append('\n');
                else
                    string.append(minHeap.poll()).append('\n');
            } else {
                minHeap.add(input);
            }
        }

        System.out.print(string);
    }
}
