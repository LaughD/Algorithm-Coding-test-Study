/*
    Code written on Nov 23, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 최적의 행렬 곱셈(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/12942
*/
class Solution {
    public int solution(int[][] matrix_sizes) {
        int NUMBER = matrix_sizes.length;
        int[][] matrixChain = new int[NUMBER][NUMBER];
        
        for (int n = 1; n < NUMBER; n++) {
            for (int i = 0; i < NUMBER-n; i++) {
                int j = i + n;
                matrixChain[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = matrixChain[i][k] + matrixChain[k+1][j] + 
                            matrix_sizes[i][0]*matrix_sizes[k][1]*matrix_sizes[j][1];
                    if (temp < matrixChain[i][j])
                        matrixChain[i][j] = temp;
                }
            }
        }
        return matrixChain[0][NUMBER-1];
    }
}
