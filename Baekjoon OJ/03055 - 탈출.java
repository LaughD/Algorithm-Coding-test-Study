/*
    Java Version: Java 15
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    03055 - 탈출, https://www.acmicpc.net/problem/3055
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static ArrayDeque<Coordinate> hedgehogs;
    static ArrayDeque<Coordinate> wetLands;
    static char[][] map;
    static int[] rowDirections;
    static int[] colDirections;
    static int rowSize;
    static int colSize;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        rowSize = Integer.parseInt(tokenizer.nextToken());
        colSize = Integer.parseInt(tokenizer.nextToken());
        hedgehogs = new ArrayDeque<>();
        wetLands = new ArrayDeque<>();
        map = new char[rowSize][colSize];
        rowDirections = new int[] {0, 0, 1, -1};
        colDirections = new int[] {1, -1, 0, 0};

        for (int row = 0; row < rowSize; row++) {
            map[row] = reader.readLine().toCharArray();
            for (int col = 0; col < colSize; col++) {
                switch (map[row][col]) {
                    case '*' -> wetLands.add(new Coordinate(row, col));
                    case 'S' -> hedgehogs.add(new Coordinate(row, col));
                }
            }
        }

        printFastestArrivalTime();
    }

    public static void printFastestArrivalTime() {
        boolean[][] visited = new boolean[rowSize][colSize];
        int time = 1;

        while (!hedgehogs.isEmpty()) {
            waterSpreads();
            int numOfCases = hedgehogs.size();

            for (int i = 0; i < numOfCases; i++) {
                Coordinate hedgehog = hedgehogs.pollFirst();
                if (visited[hedgehog.row][hedgehog.col])
                    continue;
                visited[hedgehog.row][hedgehog.col] = true;
                for (int direction = 0; direction < 4; direction++) {
                    int nextHedgehogRow = hedgehog.row + rowDirections[direction];
                    int nextHedgehogCol = hedgehog.col + colDirections[direction];

                    if (0 <= nextHedgehogRow && nextHedgehogRow < rowSize &&
                            0 <= nextHedgehogCol && nextHedgehogCol < colSize) {
                        switch (map[nextHedgehogRow][nextHedgehogCol]) {
                            case 'D' -> {
                                System.out.print(time);
                                return;
                            }
                            case '.' -> hedgehogs.addLast(
                                    new Coordinate(nextHedgehogRow, nextHedgehogCol)
                            );
                        }
                    }
                }
            }
            time++;
        }
        System.out.print("KAKTUS");
    }

    public static void waterSpreads() {
        int wetLandArea = wetLands.size();

        for (int i = 0; i < wetLandArea; i++) {
            Coordinate wetLand = wetLands.pollFirst();
            for (int direction = 0; direction < 4; direction++) {
                int nextWetLandRow = wetLand.row + rowDirections[direction];
                int nextWetLandCol = wetLand.col + colDirections[direction];

                if (0 <= nextWetLandRow && nextWetLandRow < rowSize &&
                        0 <= nextWetLandCol && nextWetLandCol < colSize &&
                        map[nextWetLandRow][nextWetLandCol] == '.') {
                    map[nextWetLandRow][nextWetLandCol] = '*';
                    wetLands.addLast(new Coordinate(nextWetLandRow, nextWetLandCol));
                }
            }
        }
    }
}

class Coordinate {
    final int row;
    final int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
