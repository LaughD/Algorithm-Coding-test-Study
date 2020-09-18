/*
    Code written on Sep 19, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    스택/큐: 주식가격(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42584
*/
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i+1; j < prices.length; j++) {
                count++;
                if (prices[i] > prices[j])
                    break;
            }
            answer[i] = count;
        }
        
        return answer;
    }
}
