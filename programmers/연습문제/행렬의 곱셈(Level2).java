/*
    Code written on Oct 16, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 행렬의 곱셈(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12949
*/
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] multipliedArr = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int element = 0;
                for (int k = 0; k < arr2.length; k++)
                    element += (arr1[i][k] * arr2[k][j]);
                multipliedArr[i][j] = element;
            }
        }
        return multipliedArr;
    }
}
