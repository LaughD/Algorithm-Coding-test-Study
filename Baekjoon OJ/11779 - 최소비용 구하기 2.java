/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    11779 - 최소비용 구하기 2, https://www.acmicpc.net/problem/11779
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Bus>> map = new ArrayList<>();
    static int numOfCities;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        numOfCities = Integer.parseInt(reader.readLine());
        for (int i = 0; i <= numOfCities; i++)
            map.add(new ArrayList<>());

        int numOfBus = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfBus; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int departure = Integer.parseInt(tokenizer.nextToken());
            int destination = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());
            map.get(departure).add(new Bus(destination, cost));
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int departure = Integer.parseInt(tokenizer.nextToken());
        int destination = Integer.parseInt(tokenizer.nextToken());
        printMinCostRouteInformation(departure, destination);
    }

    public static void printMinCostRouteInformation(int departure, int destination) {
        StringBuilder string = new StringBuilder();
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        int[] prevCity = new int[1 + numOfCities];
        int[] minCost = new int[1 + numOfCities];

        Arrays.fill(minCost, 100_000_000);
        pq.add(new Bus(departure, 0));
        while (!pq.isEmpty() && pq.peek().destination != destination) {
            Bus bus = pq.poll();
            if (bus.cost > minCost[bus.destination])
                continue;
            for (Bus nextBus: map.get(bus.destination)) {
                int nextCost = bus.cost + nextBus.cost;
                if (nextCost < minCost[nextBus.destination]) {
                    prevCity[nextBus.destination] = bus.destination;
                    minCost[nextBus.destination] = nextCost;
                    pq.add(new Bus(nextBus.destination, nextCost));
                }
            }
        }

        int[] stack = new int[1 + numOfCities];
        int index = 0;
        int city = destination;
        while (city != departure) {
            stack[index++] = city;
            city = prevCity[city];
        }

        string.append(minCost[destination]).append("\n");
        string.append(index + 1).append("\n");
        string.append(departure).append(' ');
        for (int i = index - 1; i > -1; i--)
            string.append(stack[i]).append(' ');
        System.out.print(string);
    }
}

class Bus implements Comparable<Bus> {
    final int destination;
    final int cost;

    public Bus(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus bus) {
        return this.cost - bus.cost;
    }
}
