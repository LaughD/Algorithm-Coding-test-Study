/*
    Code written on Sep 26, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    완전탐색: 카펫(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42842
*/
import java.lang.Math;

class Solution {
    public int[] solution(int brown, int yellow) {
        int rcSum = (brown+4) / 2;        // rcSum = row + col
        int rcProduct = brown + yellow;   // rcProduct = row * col
        int row = (rcSum + (int) Math.sqrt(rcSum * rcSum - 4 * rcProduct)) / 2;
        
        return new int[] {row, rcProduct/row};
    }
}
