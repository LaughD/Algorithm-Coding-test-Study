/*
    Code written on Oct 19, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 땅따먹기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12913
*/
class Solution {
    int solution(int[][] land) {
        int tempStorage = 0;
        for (int row = 1; row < land.length; row++) {
            int[] prevRow = land[row-1];
            for (int col = 0; col < land[0].length; col++) {
                tempStorage = prevRow[col];
                prevRow[col] = 0;
                land[row][col] += findMaxInArray(prevRow);
                prevRow[col] = tempStorage;
            }
        }
        return findMaxInArray(land[land.length-1]);
    }
    
    public int findMaxInArray(int[] array) {
        int max = 0;
        for (int value: array)
            if (value > max)
                max = value;
        return max;
    }
}
