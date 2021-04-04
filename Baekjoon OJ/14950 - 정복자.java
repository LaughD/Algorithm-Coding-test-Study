/*
    Code written on Apr 4, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    14950번: 정복자
    link: https://www.acmicpc.net/problem/14950
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Road> roads = new PriorityQueue<>();
        int numOfCities = Integer.parseInt(st.nextToken());
        int numOfRoads = Integer.parseInt(st.nextToken());
        int additionalCost = Integer.parseInt(st.nextToken());

        for (int roadIndex = 0; roadIndex < numOfRoads; roadIndex++) {
            st = new StringTokenizer(br.readLine());
            int cityA = Integer.parseInt(st.nextToken());
            int cityB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            roads.add(new Road(cityA, cityB, cost));
        }

        System.out.print(getCityConnectionCost(roads, numOfCities, additionalCost));
    }

    public static int getCityConnectionCost(PriorityQueue<Road> roads, 
                                            int numOfCities, int additionalCost) {
        int[] rulingCity = new int[numOfCities + 1];
        int sumOfAdditionalCost = (numOfCities - 2) * (numOfCities - 1) / 2 * additionalCost;
        int cityConnectionCost = 0;

        for (int city = 1; city < numOfCities; city++)
            rulingCity[city] = city;

        while (numOfCities != 1) {
            Road road = roads.poll();
            int cityA = road.getCityA();
            int cityB = road.getCityB();
            if (findRulingCity(rulingCity, cityA) == findRulingCity(rulingCity, cityB))
                continue;
            conquerCity(rulingCity, cityA, cityB);
            cityConnectionCost += road.getCost();
            numOfCities--;
        }
        cityConnectionCost += sumOfAdditionalCost;

        return cityConnectionCost;
    }

    public static int findRulingCity(int[] rulingCity, int city) {
        if (rulingCity[city] != city)
            rulingCity[city] = findRulingCity(rulingCity, rulingCity[city]);
        return rulingCity[city];
    }

    public static void conquerCity(int[] rulingCity, int cityA, int cityB) {
        int rulingCityA = findRulingCity(rulingCity, cityA);
        int rulingCityB = findRulingCity(rulingCity, cityB);

        if (rulingCityA < rulingCityB)
            rulingCity[rulingCityB] = rulingCityA;
        else
            rulingCity[rulingCityA] = rulingCityB;
    }
}

class Road implements Comparable<Road> {
    private final int cityA;
    private final int cityB;
    private final int cost;

    public Road(int cityA, int cityB, int cost) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road road) { return this.cost - road.getCost(); }

    public int getCityA() { return cityA; }

    public int getCityB() { return cityB; }

    public int getCost() { return cost; }
}
