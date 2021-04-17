/*
    Code written on Apr 17, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18405번: 경쟁적 전염
    link: https://www.acmicpc.net/problem/18405
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testTubeSize = Integer.parseInt(st.nextToken());
        int numOfVirusTypes = Integer.parseInt(st.nextToken());

        Virus[] viruses = new Virus[1 + numOfVirusTypes];
        for (int virusType = 0; virusType <= numOfVirusTypes; virusType++)
            viruses[virusType] = new Virus();

        for (int row = 1; row <= testTubeSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= testTubeSize; col++) {
                int virusType = Integer.parseInt(st.nextToken());
                if (virusType > 0)
                    viruses[virusType].add(new Coordinate(row, col));
            }
        }

        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int targetRow = Integer.parseInt(st.nextToken());
        int targetCol = Integer.parseInt(st.nextToken());
        int type = 0;
        for (int virusType = numOfVirusTypes; virusType > -1; virusType--) {
            for (Coordinate coordinate: viruses[virusType].getCoordinates()) {
                int reachTime = Math.abs(targetRow - coordinate.getRow())
                        + Math.abs(targetCol - coordinate.getCol());
                if (reachTime <= time) {
                    type = virusType;
                    time = reachTime;
                }
            }
        }
        System.out.print(type);
    }
}

class Virus {
    private final ArrayDeque<Coordinate> Coordinates;

    public Virus() { Coordinates = new ArrayDeque<>(); }
    public void add(Coordinate coordinate) { this.Coordinates.add(coordinate); }
    public ArrayDeque<Coordinate> getCoordinates() { return Coordinates; }
}

class Coordinate {
    private final int row;
    private final int col;

    public Coordinate(int row, int col) { this.row = row; this.col = col; }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
