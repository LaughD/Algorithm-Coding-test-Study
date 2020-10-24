/*
    Code written on Oct 24, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    02075번: N번째 큰 수
    link: https://www.acmicpc.net/problem/2075
*/
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        for (String num: br.readLine().split(" "))
            pq.add(Integer.parseInt(num));
        for (int i = 1; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            for (String num: nums) {
                pq.add(Integer.parseInt(num));
                pq.poll();
            }
        }
        bw.write(pq.peek().toString());
        bw.flush();
        bw.close();
    }
}
