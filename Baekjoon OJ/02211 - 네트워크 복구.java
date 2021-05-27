/*
    Code written on May 26, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02211번: 네트워크 복구
    link: https://www.acmicpc.net/problem/2211
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<LineInformation>[] network;
    private static int[] frontComputer;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder string = new StringBuilder();
        int numOfComputers = Integer.parseInt(tokenizer.nextToken());
        int numOfLines = Integer.parseInt(tokenizer.nextToken());
        network = new ArrayList[1 + numOfComputers];
        frontComputer = new int[1 + numOfComputers];

        for (int computer = 1; computer <= numOfComputers; computer++)
            network[computer] = new ArrayList<>();

        for (int i = 0; i < numOfLines; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int computerA = Integer.parseInt(tokenizer.nextToken());
            int computerB = Integer.parseInt(tokenizer.nextToken());
            int timeCost = Integer.parseInt(tokenizer.nextToken());
            network[computerA].add(new LineInformation(computerB, timeCost));
            network[computerB].add(new LineInformation(computerA, timeCost));
        }

        dijkstra(new int[1 + numOfComputers]);
        string.append(numOfComputers - 1).append("\n");
        for (int computer = 2; computer <= numOfComputers; computer++)
            string.append(frontComputer[computer]).append(" ").append(computer).append("\n");
        System.out.print(string);
    }

    public static void dijkstra(int[] timeCosts) {
        PriorityQueue<LineInformation> queue = new PriorityQueue<>();

        queue.add(new LineInformation(1, 0));
        Arrays.fill(timeCosts, 10_001);
        timeCosts[1] = 0;
        while (!queue.isEmpty()) {
            LineInformation lineInformation = queue.poll();
            int currentComputer = lineInformation.getComputer();
            int currentTimeCost = lineInformation.getTimeCost();
            if (currentTimeCost > timeCosts[currentComputer])
                continue;
            for (LineInformation nextLineInformation: network[currentComputer]) {
                int computer = nextLineInformation.getComputer();
                int timeCost = nextLineInformation.getTimeCost();
                if (currentTimeCost + timeCost < timeCosts[computer]) {
                    timeCosts[computer] = currentTimeCost + timeCost;
                    frontComputer[computer] = currentComputer;
                    queue.add(new LineInformation(computer, timeCosts[computer]));
                }
            }
        }
    }
}

class LineInformation implements Comparable<LineInformation> {
    private final int computer;
    private final int timeCost;

    public LineInformation(int computer, int timeCost) {
        this.computer = computer;
        this.timeCost = timeCost;
    }

    @Override
    public int compareTo(LineInformation lineInformation) {
        return this.getTimeCost() - lineInformation.getTimeCost();
    }

    public int getComputer() { return computer; }

    public int getTimeCost() { return timeCost; }
}
