/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01303 - 전쟁 - 전투, https://www.acmicpc.net/problem/1303
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char teamColor;
    static int colSize;
    static int rowSize;
    static boolean[][] checked;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        colSize = Integer.parseInt(tokenizer.nextToken());
        rowSize = Integer.parseInt(tokenizer.nextToken());
        checked = new boolean[rowSize][colSize];
        map = new char[rowSize][colSize];

        for (int row = 0; row < rowSize; row++)
            map[row] = reader.readLine().toCharArray();

        printCombatPowers();
    }

    public static void printCombatPowers() {
        int whiteTeamCombatPower = 0;
        int blueTeamCombatPower = 0;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (checked[row][col])
                    continue;
                teamColor = map[row][col];
                if (teamColor == 'W')
                    whiteTeamCombatPower += Math.pow(countNumOfSoldiers(row, col), 2);
                else
                    blueTeamCombatPower += Math.pow(countNumOfSoldiers(row, col), 2);
            }
        }
        System.out.print(whiteTeamCombatPower + " " + blueTeamCombatPower);
    }

    public static int countNumOfSoldiers(int row, int col) {
        int numOfSoldiers = 1;

        checked[row][col] = true;
        if (row > 0 && !checked[row - 1][col] && teamColor == map[row - 1][col])
            numOfSoldiers += countNumOfSoldiers(row - 1, col);
        if (col > 0 && !checked[row][col - 1] && teamColor == map[row][col - 1])
            numOfSoldiers += countNumOfSoldiers(row, col - 1);
        if (row + 1 < rowSize && !checked[row + 1][col] && teamColor == map[row + 1][col])
            numOfSoldiers += countNumOfSoldiers(row + 1, col);
        if (col + 1 < colSize && !checked[row][col + 1] && teamColor == map[row][col + 1])
            numOfSoldiers += countNumOfSoldiers(row, col + 1);

        return numOfSoldiers;
    }
}
