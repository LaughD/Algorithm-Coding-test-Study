/*
    Code written on Dec 20, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 최고의 집합(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12938
*/
import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] multiSet = new int[n];
        int remainder = s % n;
        int idx = multiSet.length;

        Arrays.fill(multiSet, s/n);
        for (int i = 0; i < remainder; i++) {
            multiSet[--idx]++;
        }

        return multiSet;
    }
}
