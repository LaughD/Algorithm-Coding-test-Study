/*
    Code written on Sep 29, 2020
    출처: Baekjoon OJ, https://www.acmicpc.net
    17478번: 재귀함수가 뭔가요?
    link: https://www.acmicpc.net/problem/17478
*/
import java.io.*;
//import java.lang.Math;

public class Main {
    private static int num;
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final String[] messages = {
            "\"재귀함수가 뭔가요?\"\n",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
            "라고 답변하였지.\n"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursion(0);
        bw.close();
    }

    public static void recursion(int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        // sb.append("____".repeat(Math.max(0, n)));
        for (int i = 0; i < n; i++)
            sb.append("____");

        if (n == num) {
            bw.write(sb + messages[0]);
            bw.write(sb + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            bw.write(sb + messages[4]);
            return;
        }

        for (int i = 0; i < 4; i++)
            bw.write(sb + messages[i]);

        recursion(++n);
        bw.write(sb + messages[4]);
    }
}
