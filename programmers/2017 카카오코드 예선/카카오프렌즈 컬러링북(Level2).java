/*
    Code written on Oct 22, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 카카오프렌즈 컬러링북(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/1829
*/
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        ArrayDeque<Integer> rows = new ArrayDeque<Integer>();
        ArrayDeque<Integer> cols = new ArrayDeque<Integer>();
        boolean[][] checked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!checked[i][j] && picture[i][j] != 0) {
                    rows.addLast(i);
                    cols.addLast(j);
                    int count = 0;
                    while (!rows.isEmpty()) {
                        int row = rows.pollFirst();
                        int col = cols.pollFirst();
                        if (!checked[row][col]) {
                            checked[row][col] = true;
                            count++;                            
                            if (row != 0 && picture[row-1][col] == picture[i][j] && !checked[row-1][col]) {
                                rows.addLast(row-1);
                                cols.addLast(col);
                            }
                            if (row != m-1 && picture[row+1][col] == picture[i][j] && !checked[row+1][col]) {
                                rows.addLast(row+1);
                                cols.addLast(col);
                            }
                            if (col != 0 && picture[row][col-1] == picture[i][j] && !checked[row][col-1]) {
                                rows.addLast(row);
                                cols.addLast(col-1);
                            }
                            if (col != n-1 && picture[row][col+1] == picture[i][j] && !checked[row][col+1]) {
                                rows.addLast(row);
                                cols.addLast(col+1);
                            }       
                        }
                    }
                    maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
