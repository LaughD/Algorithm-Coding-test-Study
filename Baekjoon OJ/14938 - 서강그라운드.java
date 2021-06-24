/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    14938 - 서강그라운드, https://www.acmicpc.net/problem/14938
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Way>> graph;
    static int[] numOfRegionalItems;
    static int numOfRegions;
    static int searchScope;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        numOfRegions = 1 + Integer.parseInt(tokenizer.nextToken());
        searchScope = Integer.parseInt(tokenizer.nextToken());
        int numOfWays = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList<>();
        numOfRegionalItems = new int[numOfRegions];
        graph.add(new ArrayList<>());

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i < numOfRegions; i++) {
            graph.add(new ArrayList<>());
            numOfRegionalItems[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 1; i <= numOfWays; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int departure = Integer.parseInt(tokenizer.nextToken());
            int destination = Integer.parseInt(tokenizer.nextToken());
            int distance = Integer.parseInt(tokenizer.nextToken());
            graph.get(departure).add(new Way(destination, distance));
            graph.get(destination).add(new Way(departure, distance));
        }

        System.out.print(findNumOfMaxItems());
    }

    public static int findNumOfMaxItems() {
        int numOfMaxItems = 0;

        for (int region = 1; region < numOfRegions; region++) {
            PriorityQueue<Way> pq = new PriorityQueue<>();
            int[] minDistance = new int[numOfRegions];
            int numOfItems = 0;

            Arrays.fill(minDistance, 16);
            pq.add(new Way(region, 0));
            minDistance[region] = 0;
            while (!pq.isEmpty() && pq.peek().distance <= searchScope) {
                Way way = pq.poll();
                if (minDistance[way.destination] < way.distance)
                    continue;
                numOfItems += numOfRegionalItems[way.destination];
                for (Way nextWay: graph.get(way.destination)) {
                    int distance = way.distance + nextWay.distance;
                    if (distance < minDistance[nextWay.destination]) {
                        minDistance[nextWay.destination] = distance;
                        pq.add(new Way(nextWay.destination, distance));
                    }
                }
            }
            numOfMaxItems = Math.max(numOfMaxItems, numOfItems);
        }
        return numOfMaxItems;
    }
}

class Way implements Comparable<Way> {
    final int destination;
    final int distance;

    public Way(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public int compareTo(Way way) {
        return this.distance - way.distance;
    }
}
