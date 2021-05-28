/*
    Code written on May 28, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    16234번: 인구 이동
    link: https://www.acmicpc.net/problem/16234
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int width;
    private static int minPopulation;
    private static int maxPopulation;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        width = Integer.parseInt(tokenizer.nextToken());
        minPopulation = Integer.parseInt(tokenizer.nextToken());
        maxPopulation = Integer.parseInt(tokenizer.nextToken());
        map = new int [width][width];

        for (int row = 0; row < width; row++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int col = 0; col < width; col++)
                map[row][col] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.print(countNumOfMoves());
    }

    public static int countNumOfMoves() {
        int totalNumOfMoves = 0;
        while (true) {
            boolean[][] visited = new boolean[width][width];
            int numOfMoves = 0;
            for (int row = 0; row < width; row++) {
                for (int col = 0; col < width; col++) {
                    if (visited[row][col])
                        continue;
                    if (isBorderOpen(new Coordinate(row, col), visited))
                        numOfMoves = 1;
                }
            }
            if (numOfMoves == 0)
                return totalNumOfMoves;
            totalNumOfMoves += numOfMoves;
        }
    }

    public static boolean isBorderOpen(Coordinate nation, boolean[][] visited) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        ArrayDeque<Coordinate> union = new ArrayDeque<>();
        int totalPopulation = 0;
        int numOfNations = 0;
        boolean isOpen = false;

        queue.add(nation);
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.pollFirst();
            int row = coordinate.getRow();
            int col = coordinate.getCol();
            if (visited[row][col])
                continue;
            visited[row][col] = true;
            union.add(coordinate);
            totalPopulation += map[row][col];
            numOfNations += 1;
            if (0 < row) {
                int populationDiff = Math.abs(map[row - 1][col] - map[row][col]);
                if (minPopulation <= populationDiff && populationDiff <= maxPopulation)
                    queue.addLast(new Coordinate(row - 1, col));
            }
            if (row < width - 1) {
                int populationDiff = Math.abs(map[row + 1][col] - map[row][col]);
                if (minPopulation <= populationDiff && populationDiff <= maxPopulation)
                    queue.addLast(new Coordinate(row + 1, col));
            }
            if (0 < col) {
                int populationDiff = Math.abs(map[row][col - 1] - map[row][col]);
                if (minPopulation <= populationDiff && populationDiff <= maxPopulation)
                    queue.addLast(new Coordinate(row, col - 1));
            }
            if (col < width - 1) {
                int populationDiff = Math.abs(map[row][col + 1] - map[row][col]);
                if (minPopulation <= populationDiff && populationDiff <= maxPopulation)
                    queue.addLast(new Coordinate(row, col + 1));
            }
        }

        if (union.size() > 1) {
            isOpen = true;
            int population = totalPopulation / numOfNations;
            for (Coordinate coordinate: union)
                map[coordinate.getRow()][coordinate.getCol()] = population;
        }
        return isOpen;
    }
}

class Coordinate {
    private final int row;
    private final int col;

    public Coordinate(int row, int col) { this.row = row; this.col = col; }

    public int getRow() { return row; }

    public int getCol() { return col; }
}
