/*
    Code written on Jan 11, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 프렌즈4블록(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17679
*/
import java.util.ArrayDeque;
import java.util.HashSet;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] transposedBoard = new char[n][m];
        int removedTotal = 0;
        int removedNow;
        for (int x = 0; x < m; x++)
            for (int y = 0; y < n; y++)
                transposedBoard[y][x] = board[x].charAt(n-1-y);

        while (true) {
            removedNow = removeBlocks(n-1, m-1, transposedBoard);
            if (removedNow == 0)
                break;
            relocateBlocks(n-1, m-1, transposedBoard);
            removedTotal += removedNow;
        }
        return removedTotal;
    }

    public int removeBlocks(int n, int m, char[][] board) {
        HashSet<Coordinate> coordinates = new HashSet<>();
        int removedNow = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                char block = board[x][y];
                if (block != '.' && block == board[x+1][y+1] &&
                        block == board[x+1][y] && block == board[x][y+1]) {
                    coordinates.add(new Coordinate(x, y));
                    coordinates.add(new Coordinate(x+1, y));
                    coordinates.add(new Coordinate(x, y+1));
                    coordinates.add(new Coordinate(x+1, y+1));
                }
            }
        }

        for (Coordinate coordinate: coordinates) {
            board[coordinate.x][coordinate.y] = '.';
            removedNow++;
        }
        return removedNow;
    }

    public void relocateBlocks(int n, int m, char[][] board) {
        for (int x = 0; x <= n; x++) {
            ArrayDeque<Integer> vacancies = new ArrayDeque<>();
            for (int y = m; y > -1; y--) {
                if (board[x][y] == '.') {
                    vacancies.addLast(y);
                } else if (!vacancies.isEmpty()) {
                    int idx = vacancies.pollFirst();
                    vacancies.addLast(y);
                    board[x][idx] = board[x][y];
                    board[x][y] = '.';
                }
            }
        }
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return x * 100 + y;
    }
}
