/*
    Code written on Dec 13, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 영어 끝말잇기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12981
*/
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        int[] turnAndCycle = new int[2];
        int uninterrupted = 0;
        char firstLetter = words[0].charAt(0);
        
        for (String word: words) {
            if ((word.charAt(0) != firstLetter) || (wordSet.contains(word))) {
                turnAndCycle[0] = 1 + (uninterrupted % n);
                turnAndCycle[1] = 1 + (uninterrupted / n);
                break;
            }
            firstLetter = word.charAt(word.length()-1);
            wordSet.add(word);
            uninterrupted++;
        } 

        return turnAndCycle;
    }
}
