/*
    Code written on Jan 7, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01021번: 회전하는 큐
    link: https://www.acmicpc.net/problem/1021
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lastNum = Integer.parseInt(br.readLine().split(" ")[0]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        int minRotation = 0;

        for (int i = 1; i <= lastNum; i++) {
            list.addLast(i);
        }

        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = list.indexOf(target);
            int rotation = 0;

            if (list.size()/2 >= targetIdx) {
                while (target != list.getFirst()) {
                    rotation++;
                    list.addLast(list.removeFirst());
                }
            } else {
                while (target != list.getFirst()) {
                    rotation++;
                    list.addFirst(list.removeLast());
                }
            }
            list.remove(0);
            minRotation += rotation;
        }

        System.out.print(minRotation);
    }
}
