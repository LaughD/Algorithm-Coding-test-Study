/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01647 - 도시 분할 계획, https://www.acmicpc.net/problem/1647
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Road> priorityQueue = new PriorityQueue<>();
    static int[] parentHouse;
    static int numOfHouses;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        numOfHouses = Integer.parseInt(tokenizer.nextToken());
        parentHouse = new int[1 + numOfHouses];
        int numOfRoads = Integer.parseInt(tokenizer.nextToken());

        for (int house = 1; house <= numOfHouses; house++)
            parentHouse[house] = house;
        for (int i = 0; i < numOfRoads; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            priorityQueue.add(new Road(
                    Integer.parseInt(tokenizer.nextToken()),
                    Integer.parseInt(tokenizer.nextToken()),
                    Integer.parseInt(tokenizer.nextToken()))
            );
        }

        printMinCost();
    }

    public static void printMinCost() {
        int minCost = 0;
        while (numOfHouses != 2) {
            Road road = priorityQueue.poll();
            if (findParentHouse(road.houseA) == findParentHouse(road.houseB))
                continue;
            connectHouses(road.houseA, road.houseB);
            numOfHouses--;
            minCost += road.cost;
        }
        System.out.print(minCost);
    }

    public static int findParentHouse(int house) {
        if (parentHouse[house] == house)
            return house;
        return parentHouse[house] = findParentHouse(parentHouse[house]);
    }

    public static void connectHouses(int houseA, int houseB) {
        houseA = parentHouse[houseA];
        houseB = parentHouse[houseB];
        if (houseA < houseB)
            parentHouse[houseB] = houseA;
        else
            parentHouse[houseA] = houseB;
    }
}

class Road implements Comparable<Road> {
    final int houseA;
    final int houseB;
    final int cost;

    public Road(int houseA, int houseB, int cost) {
        this.houseA = houseA;
        this.houseB = houseB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road road) {
        return this.cost - road.cost;
    }
}
