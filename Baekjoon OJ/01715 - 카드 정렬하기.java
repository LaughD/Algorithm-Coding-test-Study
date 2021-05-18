/*
    Code written on May 18, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01715번: 카드 정렬하기
    link: https://www.acmicpc.net/problem/1715
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numOfCardBundles = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfCardBundles; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int totalComparison = 0;
        while (pq.size() > 1) {
            int comparison = pq.poll() + pq.poll();
            totalComparison += comparison;
            pq.add(comparison);
        }
        System.out.print(totalComparison);
    }
}
