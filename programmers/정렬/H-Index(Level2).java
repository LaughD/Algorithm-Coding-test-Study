/*
    Code written on Sep 23, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    정렬: H-Index(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42747
*/
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length-i) {
                answer = citations.length - i;
                break;
            }
        }
        
        return answer;
    }
}
