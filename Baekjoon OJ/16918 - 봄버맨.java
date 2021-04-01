/*
    Code written on Apr 2, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    16918번: 봄버맨
    link: https://www.acmicpc.net/problem/16918
*/
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static HashSet<BombCoordinate> bombCoordinates;
    private static int height;
    private static int width;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        if (time == 1) {
            for (int row = 0; row < height; row++)
                bw.write(br.readLine() + "\n");
        } else if (time % 2 == 0) {
            char[] line = new char[width];
            Arrays.fill(line, 'O');
            for (int row = 0; row < height; row++)
                bw.write(String.valueOf(line) + "\n");
        } else {
            bombCoordinates = new HashSet<>();
            char[][] field = new char[height][width];
            for (int row = 0; row < height; row++)
                field[row] = br.readLine().toCharArray();

            activeBomberman(field);
            if (time % 4 == 1) {
                bombCoordinates.clear();
                activeBomberman(field);
            }

            for (int row = 0; row < height; row++)
                bw.write(String.valueOf(field[row]) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void getOldBombCoordinates(char[][] field) {
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                if (field[row][col] == 'O')
                    bombCoordinates.add(new BombCoordinate(row, col));
    }

    public static void explodeOldBombs(char[][] field) {
        int[] dy = new int[] {0, 0, 1, -1};
        int[] dx = new int[] {1, -1, 0, 0};
        for (BombCoordinate bombCoordinate: bombCoordinates) {
            field[bombCoordinate.getY()][bombCoordinate.getX()] = '.';
            for (int i = 0; i < 4; i++) {
                int y = bombCoordinate.getY() + dy[i];
                int x = bombCoordinate.getX() + dx[i];
                if (0 <= y && y < height && 0 <= x && x < width)
                    field[y][x] = '.';
            }
        }
    }

    public static void setUpNewBombs(char[][] field) {
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                if (field[row][col] == '.')
                    field[row][col] = 'O';
    }

    public static void activeBomberman(char[][] field) {
        getOldBombCoordinates(field);
        setUpNewBombs(field);
        explodeOldBombs(field);
    }
}

class BombCoordinate {
    private final int y;
    private final int x;

    public BombCoordinate(int y, int x) { this.y = y; this.x = x; }
    @Override
    public int hashCode() { return y * 201 + x; }
    public int getY() { return this.y; };
    public int getX() { return this.x; };
}
