/*
    Code written on Nov 16, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 가장 큰 정사각형 찾기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12905
*/
class Solution {
    public int solution(int[][] board) {
        if (board.length == 1 || board[0].length == 1) {
            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[0].length; j++)
                    if (board[i][j] == 1)
                        return 1;
            return 0;
        }
        
        int length = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++){
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j]), board[i-1][j-1]) + 1;
                    if (length < board[i][j])
                        length = board[i][j];
                }
            }
        }
        return length*length;
    }
}
