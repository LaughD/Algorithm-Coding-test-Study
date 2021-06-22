/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01987 - 알파벳, https://www.acmicpc.net/problem/1987
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static boolean[] isIncluded = new boolean[91];
    static int rowSize;
    static int colSize;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        rowSize = Integer.parseInt(tokenizer.nextToken());
        colSize = Integer.parseInt(tokenizer.nextToken());
        board = new char[rowSize][colSize];
        for (int i = 0; i < rowSize; i++)
            board[i] = reader.readLine().toCharArray();

        rowSize--;
        colSize--;
        System.out.print(findMaxSetLength(0, 0));
    }

    public static int findMaxSetLength(int row, int col) {
        int setLength = 1;

        isIncluded[board[row][col]] = true;
        if (0 < row && !isIncluded[board[row - 1][col]])
            setLength = Math.max(setLength, 1 + findMaxSetLength(row - 1, col));
        if (row < rowSize && !isIncluded[board[row + 1][col]])
            setLength = Math.max(setLength, 1 + findMaxSetLength(row + 1, col));
        if (0 < col && !isIncluded[board[row][col - 1]])
            setLength = Math.max(setLength, 1 + findMaxSetLength(row, col - 1));
        if (col < colSize && !isIncluded[board[row][col + 1]])
            setLength = Math.max(setLength, 1 + findMaxSetLength(row, col + 1));
        isIncluded[board[row][col]] = false;

        return setLength;
    }
}
