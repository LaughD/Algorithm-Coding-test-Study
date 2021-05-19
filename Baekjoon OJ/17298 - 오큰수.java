/*
    Code written on May 19, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    17298번: 오큰수
    link: https://www.acmicpc.net/problem/17298
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sequenceSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[sequenceSize];
        int[] nge = new int[sequenceSize];

        for (int i = 0; i < sequenceSize; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            nge[i] = -1;
            while (!stack.isEmpty() && sequence[stack.peekLast()] < sequence[i])
                nge[stack.pollLast()] = sequence[i];
            stack.addLast(i);
        }
        for (int number: nge)
            sb.append(number).append(' ');
        System.out.print(sb);
    }
}
