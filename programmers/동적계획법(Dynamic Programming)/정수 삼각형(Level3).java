/*
    Code written on Sep 25, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    동적계획법(Dynamic Programming): 정수 삼각형(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43105
*/
class Solution {
    public int solution(int[][] triangle) {
        for (int i = triangle.length-1; i > 0; i--)
            for (int j = 0; j < triangle[i].length-1; j++)
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
        
        return triangle[0][0];
    }
}
