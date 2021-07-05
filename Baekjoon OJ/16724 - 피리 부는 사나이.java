/*
    Java Version: Java 15
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    16724 - 피리 부는 사나이, https://www.acmicpc.net/problem/16724
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int[][] visited;
    static int rowSize;
    static int colSize;
    static int numOfSafeZones = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        rowSize = Integer.parseInt(tokenizer.nextToken());
        colSize = Integer.parseInt(tokenizer.nextToken());
        map = new char[rowSize][colSize];
        visited = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++)
            map[row] = reader.readLine().toCharArray();

        printNumOfSafeZones();
    }

    public static void printNumOfSafeZones() {
        for (int row = 0; row < rowSize; row++)
            for (int col = 0; col < colSize; col++)
                if (visited[row][col] == 0)
                    moveAlongDirection(row, col);
        System.out.print(numOfSafeZones);
    }

    public static void moveAlongDirection(int row, int col) {
        switch (visited[row][col]) {
            case 0 -> {
                visited[row][col] = 1;
                switch (map[row][col]) {
                    case 'U' -> moveAlongDirection(row - 1, col);
                    case 'D' -> moveAlongDirection(row + 1, col);
                    case 'L' -> moveAlongDirection(row, col - 1);
                    case 'R' -> moveAlongDirection(row, col + 1);
                }
                visited[row][col] = -1;
            }
            case 1 -> numOfSafeZones++;
        }
    }
}
