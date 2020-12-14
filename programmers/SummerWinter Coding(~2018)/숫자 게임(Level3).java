/*
    Code written on Dec 14, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 숫자 게임(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12987
*/
import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int maxPoint = 0;
        int idx = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        for (int b: B) {
            if (A[idx] < b) {
                idx++;
                maxPoint++;
            }
        }
        
        return maxPoint;
    }
}
