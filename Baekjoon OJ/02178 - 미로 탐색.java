/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    02178 - 미로 탐색, https://www.acmicpc.net/problem/2178
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        ArrayDeque<Location> queue = new ArrayDeque<>();
        int rowSize = Integer.parseInt(tokenizer.nextToken());
        int colSize = Integer.parseInt(tokenizer.nextToken());
        int numOfMoves = 1;
        char[][] maze = new char[rowSize][colSize];
        for (int i = 0; i < rowSize; i++)
            maze[i] = reader.readLine().toCharArray();

        queue.add(new Location(0, 0));
        maze[0][0] = '0';
        rowSize--;
        colSize--;
        loop:
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Location location = queue.pollFirst();
                if  (location.row == rowSize && location.col == colSize)
                    break loop;
                if (location.row > 0 && maze[location.row - 1][location.col] == '1') {
                    maze[location.row - 1][location.col] = '0';
                    queue.addLast(new Location(location.row - 1, location.col));
                }
                if (location.row < rowSize && maze[location.row + 1][location.col] == '1') {
                    maze[location.row + 1][location.col] = '0';
                    queue.addLast(new Location(location.row + 1, location.col));
                }
                if (location.col > 0 && maze[location.row][location.col - 1] == '1') {
                    maze[location.row][location.col - 1] = '0';
                    queue.addLast(new Location(location.row, location.col - 1));
                }
                if (location.col < colSize && maze[location.row][location.col + 1] == '1') {
                    maze[location.row][location.col + 1] = '0';
                    queue.addLast(new Location(location.row, location.col + 1));
                }
            }
            numOfMoves++;
        }
        System.out.print(numOfMoves);
    }
}

class Location {
    final int row;
    final int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
