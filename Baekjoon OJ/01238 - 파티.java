/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01238 - 파티, https://www.acmicpc.net/problem/1238
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Road>> map;
    static ArrayList<ArrayList<Road>> reversedMap;
    static int numOfCities;
    static int targetCity;
    static int inf = 100_000;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        numOfCities = Integer.parseInt(tokenizer.nextToken());
        int numOfRoads = Integer.parseInt(tokenizer.nextToken());
        targetCity = Integer.parseInt(tokenizer.nextToken());
        map = new ArrayList<>();
        reversedMap = new ArrayList<>();

        for (int i = 0; i <= numOfCities; i++) {
            map.add(new ArrayList<>());
            reversedMap.add(new ArrayList<>());
        }

        for (int i = 0; i < numOfRoads; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int cityA = Integer.parseInt(tokenizer.nextToken());
            int cityB = Integer.parseInt(tokenizer.nextToken());
            int time = Integer.parseInt(tokenizer.nextToken());
            map.get(cityA).add(new Road(cityB, time));
            reversedMap.get(cityB).add(new Road(cityA, time));
        }

        System.out.print(findLongestTimeRequired());
    }

    public static int findLongestTimeRequired() {
        int[] goTimes = findShortestTimes(reversedMap);
        int[] comeBackTimes = findShortestTimes(map);
        int longestTimeRequired = 0;

        for (int city = 1; city <= numOfCities; city++)
            longestTimeRequired = Math.max(
                    longestTimeRequired,
                    goTimes[city] + comeBackTimes[city]
            );
        return longestTimeRequired;
    }

    public static int[] findShortestTimes(ArrayList<ArrayList<Road>> map) {
        PriorityQueue<Road> queue = new PriorityQueue<>();
        int[] shortestTimes = new int[1 + numOfCities];

        queue.add(new Road(targetCity, 0));
        Arrays.fill(shortestTimes, inf);
        shortestTimes[targetCity] = 0;
        while (!queue.isEmpty()) {
            Road road = queue.poll();
            if (road.timeRequired > shortestTimes[road.destination])
                continue;
            for (Road nextRoad: map.get(road.destination)) {
                int nextTimeRequired = road.timeRequired + nextRoad.timeRequired;
                if (nextTimeRequired < shortestTimes[nextRoad.destination]) {
                    shortestTimes[nextRoad.destination] = nextTimeRequired;
                    queue.add(new Road(nextRoad.destination, nextTimeRequired));
                }
            }
        }
        return shortestTimes;
    }
}

class Road implements Comparable<Road> {
    final int destination;
    final int timeRequired;

    public Road(int destination, int timeRequired) {
        this.destination = destination;
        this.timeRequired = timeRequired;
    }

    @Override
    public int compareTo(Road road) {
        return this.timeRequired - road.timeRequired;
    }
}
