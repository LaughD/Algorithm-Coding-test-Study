/*
    Code written on Dec 11, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [3차] 자동완성(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/17685
*/
import java.util.Arrays;

class Solution {
    public int solution(String[] words) {
        int numInputsTotal = 0;
        int numPrevWordInputs = 0;
        int numCurWordInputs;
        int shorterStrLength;

        Arrays.sort(words);
        for (int i = 1; i < words.length; i++) {
            if (words[i].startsWith(words[i-1])) {
                numPrevWordInputs = words[i-1].length();
                numCurWordInputs = numPrevWordInputs + 1;
            } else {
                shorterStrLength = Math.min(words[i-1].length(), words[i].length());
                numCurWordInputs = 0;
                for (int j = 0; j < shorterStrLength; j++) {
                    numCurWordInputs++;
                    if (words[i-1].charAt(j) != words[i].charAt(j)) {
                        break;
                    }
                }
                numPrevWordInputs = Math.max(numPrevWordInputs, numCurWordInputs);
            }
            numInputsTotal += numPrevWordInputs;
            numPrevWordInputs = numCurWordInputs;
        }
        numInputsTotal += numPrevWordInputs;

        return numInputsTotal;
    }
}
