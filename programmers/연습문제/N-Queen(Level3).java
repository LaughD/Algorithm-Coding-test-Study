/*
    Code written on Oct 28, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: N-Queen(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12952
*/
class Solution {
    int countCase = 0;
    int lastRow;
    
    public int solution(int n) {
        lastRow = n;
        for (int col = 1; col <= lastRow; col++) {
            int[] cols = new int[lastRow+1];
            backTracking(1, col, cols);
        }
        return countCase;
    }
    
    public boolean canPutQueen(int row, int thisCol, int[] cols)  {
        for (int i = 1; i < row; i++) {
            if (cols[i] == thisCol)
                return false;
            else if ((Math.abs(cols[i] - thisCol)) == (row - i))
                return false;
        }
        return true;
    }
    
    public void backTracking(int row, int thisCol, int[] cols) {
        if (row == lastRow) {
            countCase++;
        } else {
            cols[row] = thisCol;
            for (int nextCol = 1; nextCol <= lastRow; nextCol++)
                if (canPutQueen(row+1, nextCol, cols))
                    backTracking(row+1, nextCol, cols);
        }
    }
}
