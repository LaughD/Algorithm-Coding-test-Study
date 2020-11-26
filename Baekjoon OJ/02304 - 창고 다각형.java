/*
    Code written on Nov 26, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    02304번: 창고 다각형
    link: https://www.acmicpc.net/problem/2304
*/
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] ary1, int[] ary2) -> ary2[1] - ary1[1]);

        final int PILLARS = Integer.parseInt(br.readLine());
        for (int i = 0; i < PILLARS; i++)
            pq.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());

        int[] poll = pq.poll();
        int[] minAndMax = {poll[0], poll[0]};
        int area = poll[1];
        while (!pq.isEmpty()) {
            poll = pq.poll();
            if (poll[0] < minAndMax[0]) {
                area += (minAndMax[0]-poll[0]) * poll[1];
                minAndMax[0] = poll[0];
            } else if (poll[0] > minAndMax[1]) {
                area += (poll[0]-minAndMax[1]) * poll[1];
                minAndMax[1] = poll[0];
            }
        }
        System.out.println(area);
    }
}
