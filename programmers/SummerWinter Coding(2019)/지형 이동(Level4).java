/*
    Code written on Apr 3, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(2019): 지형 이동(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/62050
*/
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] land, int height) {
        int landSize = land.length;
        PriorityQueue<Space> spaces = new PriorityQueue<>();
        boolean[][] visited = new boolean[landSize][landSize];
        int[] dRow = new int[] {0, 0, 1, -1};
        int[] dCol = new int[] {1, -1, 0, 0};
        int numOfSpaces = landSize * landSize;
        int numOfVisited = 0;
        int minCost = 0;

        spaces.add(new Space(0, 0, 0));
        while (numOfVisited < numOfSpaces) {
            Space space = spaces.poll();
            int row = space.getRow();
            int col = space.getCol();
            if (visited[row][col])
                continue;
            numOfVisited++;
            visited[row][col] = true;
            minCost += space.getCost();
            for (int direction = 0; direction < 4; direction++) {
                int nRow = row + dRow[direction];    // nRow: next row number
                int nCol = col + dCol[direction];    // nCol: next column number
                if (0 <= nRow && nRow < landSize && 0 <= nCol && nCol < landSize) {
                    int difference = Math.abs(land[row][col] - land[nRow][nCol]);
                    if (difference <= height)    // difference: height difference
                        spaces.add(new Space(0, nRow, nCol));
                    else
                        spaces.add(new Space(difference, nRow, nCol));
                }
            }
        }
        return minCost;
    }
}

class Space implements Comparable<Space> {
    private final int cost;
    private final int row;
    private final int col;

    public Space(int cost, int row, int col) {
        this.cost = cost;
        this.row = row;
        this.col = col;
    }

    public int getCost() { return this.cost; }

    public int getRow() { return this.row; }

    public int getCol() { return this.col; }

    @Override
    public int compareTo(Space space) { return this.cost - space.getCost(); }
}
