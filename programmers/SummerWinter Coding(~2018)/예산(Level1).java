/*
    Code written on Nov 8, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 예산(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/12982
*/
import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int price: d) {
            budget -= price;
            if (budget < 0)
                break;
            answer++;
        }  
        return answer;
    }
}
