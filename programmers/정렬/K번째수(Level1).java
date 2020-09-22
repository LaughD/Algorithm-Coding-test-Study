/*
    Code written on Sep 22, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    정렬: K번째수(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42748
*/
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] arraySlice = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(arraySlice);
            answer[i] = arraySlice[commands[i][2]-1];
        }
        
        return answer;
    }
}
