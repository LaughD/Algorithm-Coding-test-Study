/*
    Code written on Sep 27, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    동적계획법(Dynamic Programming): 등굣길(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42898
*/
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] location = new int[n+1][m+1];
        
        for (int[] puddle: puddles)
            location[puddle[1]][puddle[0]] = -1;
        
        location[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (location[i][j] < 0) {
                    location[i][j] = 0;
                } else {
                    if (i != 1)
                        location[i][j] += location[i-1][j];
                    if (j != 1)
                        location[i][j] += location[i][j-1];
                    location[i][j] %= 1000000007;
                }
            }
        }
        
        return location[n][m];
    }
}
