/*
    Code written on Sep 23, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    완전탐색: 모의고사(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42840
*/
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] studentA = {1, 2, 3, 4, 5};
        int[] studentB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] studentC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == studentA[i % studentA.length]) scores[0]++;
            if (answers[i] == studentB[i % studentB.length]) scores[1]++;
            if (answers[i] == studentC[i % studentC.length]) scores[2]++;
        }
        
        ArrayList<Integer> firstPlace = new ArrayList<Integer>();
        int maxScore = Arrays.stream(scores).max().getAsInt();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore)
                firstPlace.add(i+1);
        }

        int[] result = new int[firstPlace.size()];
        Arrays.setAll(result, firstPlace::get);

        return result;
    }
}
