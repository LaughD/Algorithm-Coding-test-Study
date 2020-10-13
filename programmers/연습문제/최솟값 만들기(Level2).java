/*
    Code written on Oct 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 최솟값 만들기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12941
*/
import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++)
            answer += A[i] * B[A.length-i-1];
        return answer;
    }
}
