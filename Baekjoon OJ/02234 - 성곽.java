/*
    Code written on Apr 5, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    02234번: 성곽
    link: https://www.acmicpc.net/problem/2234
*/
import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static HashMap<Integer, Integer> roomSizeMap;
    private static int[][] map;
    private static int width;
    private static int height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        roomSizeMap = new HashMap<>();
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        map = new int[height][width];

        for (int row = 0; row < height; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < width; col++)
                map[row][col] = Integer.parseInt(st.nextToken());
        }

        map = makeRoomsOnMap();
        bw.write(roomSizeMap.size() + "\n");
        bw.write(getMaxRoomSize() + "\n");
        bw.write(String.valueOf(getMaxCombinedRoomSize()));
        bw.flush();
        bw.close();
    }

    public static int[][] makeRoomsOnMap() {
        int[][] mapWithRooms = new int[height][width];
        int room = 1;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (mapWithRooms[row][col] != 0)
                    continue;
                int roomSize = measureRoomSize(mapWithRooms, room, row, col);
                roomSizeMap.put(room, roomSize);
                room++;
            }
        }
        return mapWithRooms;
    }

    public static int measureRoomSize(int[][] mapWithRooms, int room, int row, int col) {
        ArrayDeque<Integer> rows = new ArrayDeque<>();
        ArrayDeque<Integer> cols = new ArrayDeque<>();
        int[] wallChecker = new int[] {2, 0, 3, 1};
        int[] dRow = new int[] {0, 0, 1, -1};
        int[] dCol = new int[] {1, -1, 0, 0};
        int roomSize = 0;

        rows.addLast(row);
        cols.addLast(col);
        while (!rows.isEmpty()) {
            int thisRow = rows.pollFirst();
            int thisCol = cols.pollFirst();
            if (mapWithRooms[thisRow][thisCol] != 0)
                continue;
            mapWithRooms[thisRow][thisCol] = room;
            roomSize++;
            for (int direction = 0; direction < 4; direction++) {
                if (((map[thisRow][thisCol] >> wallChecker[direction]) & 1) == 1)
                    continue;
                rows.addLast(thisRow + dRow[direction]);
                cols.addLast(thisCol + dCol[direction]);
            }
        }
        return roomSize;
    }

    public static int getMaxRoomSize() {
        int maxRoomSize = 0;
        for (int roomSize: roomSizeMap.values())
            if (maxRoomSize < roomSize)
                maxRoomSize = roomSize;
        return maxRoomSize;
    }

    public static int getMaxCombinedRoomSize() {
        int[] dRow = new int[] {0, 1};
        int[] dCol = new int[] {1, 0};
        int maxCombinedRoomSize = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int roomA = map[row][col];
                for (int direction = 0; direction < 2; direction++) {
                    int adjacentRow = row + dRow[direction];
                    int adjacentCol = col + dCol[direction];
                    if (adjacentRow >= height || adjacentCol >= width)
                        continue;
                    int roomB = map[adjacentRow][adjacentCol];
                    if (roomA == roomB)
                        continue;
                    int combinedRoomSize = roomSizeMap.get(roomA) + roomSizeMap.get(roomB);
                    if (combinedRoomSize > maxCombinedRoomSize)
                        maxCombinedRoomSize = combinedRoomSize;
                }
            }
        }
        return maxCombinedRoomSize;
    }
}
